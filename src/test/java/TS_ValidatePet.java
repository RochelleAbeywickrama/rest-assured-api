import com.fasterxml.jackson.core.JsonProcessingException;
import com.sysco.qe.automation.data.CreatePetModel;
import com.sysco.qe.automation.functions.PetStoreService;
import com.sysco.qe.automation.utils.Helper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.sysco.qe.automation.config.Config.*;

public class TS_ValidatePet {

    public static final int id = 1234;
    public static final String name = "roch_1234";
    public static final String status = "pending";
    public static final String newStatus = "available";

    @Test(priority = 1)
    public static void test_AddPetToPetStore() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(CreatePetModel.builder()
                .id(id)
                .name(name)
                .status(status)
                .build());
        CreatePetModel model = PetStoreService.createPet(CREATE_PET_PATH, HttpStatus.SC_OK, jsonBody);
        Assert.assertEquals(model.getId(),id);
        Assert.assertEquals(model.getName(),name);
        Assert.assertEquals(model.getStatus(),status);
    }

    @Test(priority = 2)
    public static void test_UpdatePetStatus() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(CreatePetModel.builder()
                .id(id)
                .status(newStatus)
                .build());
        CreatePetModel model = PetStoreService.updatePet(UPDATE_PET_PATH, HttpStatus.SC_OK, jsonBody);
        Assert.assertEquals(model.getId(),id);
        Assert.assertEquals(model.getStatus(),newStatus);
    }

    @Test(priority = 3)
    public static void test_GetPetById(){

        CreatePetModel model = PetStoreService.getPetIById(VIEW_PET_PATH, HttpStatus.SC_OK, id);
        Assert.assertEquals(model.getId(),id);
        Assert.assertEquals(model.getStatus(),newStatus);

    }

    @AfterClass
    public static void test_RemovePet(){
        PetStoreService.deletePet(DELETE_PET_PATH, HttpStatus.SC_OK, id);
    }

}
