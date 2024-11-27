//package services;
//
//import com.petslab.petslab.entities.Pet;
//import com.petslab.petslab.dto.daos.PetStatDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import repositories.PetRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class PetServiceImplTest {
//
//    @Mock
//    private PetRepository petRepository;
//
//    @InjectMocks
//    private PetServiceImpl petService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createPet_ShouldSavePet() {
//        Pet pet = new Pet(1, "Buddy", "Dog", "Golden Retriever", 3);
//        when(petRepository.save(pet)).thenReturn(pet);
//
//        Pet createdPet = petService.createPet(pet);
//
//        assertNotNull(createdPet);
//        assertEquals(pet.getId(), createdPet.getId());
//        verify(petRepository, times(1)).save(pet);
//    }
//
//    @Test
//    void getAllPets_ShouldReturnListOfPets() {
//        List<Pet> pets = new ArrayList<>();
//        pets.add(new Pet(1, "Buddy", "Dog", "Golden Retriever", 3));
//        when(petRepository.findAll()).thenReturn(pets);
//
//        List<Pet> result = petService.getAllPets();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(petRepository, times(1)).findAll();
//    }
//
//    @Test
//    void getPetById_ShouldReturnPet_WhenExists() {
//        Pet pet = new Pet(1, "Buddy", "Dog", "Golden Retriever", 3);
//        when(petRepository.findById(1)).thenReturn(Optional.of(pet));
//
//        Pet result = petService.getPetById(1);
//
//        assertNotNull(result);
//        assertEquals(pet.getId(), result.getId());
//        verify(petRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void getPetById_ShouldThrowException_WhenNotFound() {
//        when(petRepository.findById(1)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(RuntimeException.class, () -> petService.getPetById(1));
//        assertEquals("Pet not found", exception.getMessage());
//        verify(petRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void updatePet_ShouldCallRepositoryUpdate() {
//        Pet petDetails = new Pet(1, "Buddy", "Dog", "Golden Retriever", 4);
//
//        petService.updatePet(1, petDetails);
//
//        verify(petRepository, times(1)).updatePetById(
//                1,
//                petDetails.getName(),
//                petDetails.getType(),
//                petDetails.getBreed(),
//                petDetails.getAge()
//        );
//    }
//
//    @Test
//    void deletePetById_ShouldDeletePet() {
//        Pet pet = new Pet(1, "Buddy", "Dog", "Golden Retriever", 3);
//        when(petRepository.findById(1)).thenReturn(Optional.of(pet));
//
//        petService.deletePetById(1);
//
//        verify(petRepository, times(1)).delete(pet);
//    }
//
//    @Test
//    void deletePetsByName_ShouldCallRepositoryDelete() {
//        String name = "Buddy";
//
//        petService.deletePetsByName(name);
//
//        verify(petRepository, times(1)).deletePetsByName(name);
//    }
//
//    @Test
//    void getPetsByType_ShouldReturnListOfPets() {
//        List<Pet> pets = new ArrayList<>();
//        pets.add(new Pet(1, "Buddy", "Dog", "Golden Retriever", 3));
//        when(petRepository.getPetsByType("Dog")).thenReturn(pets);
//
//        List<Pet> result = petService.getPetsByType("Dog");
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(petRepository, times(1)).getPetsByType("Dog");
//    }
//
//    @Test
//    void getPetsByBreed_ShouldReturnListOfPets() {
//        List<Pet> pets = new ArrayList<>();
//        pets.add(new Pet(1, "Buddy", "Dog", "Golden Retriever", 3));
//        when(petRepository.getPetsByBreed("Dog")).thenReturn(pets);
//        List<Pet> result = petService.getPetsByBreed("Dog");
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(petRepository, times(1)).getPetsByBreed("Dog");
//    }
//
////    @Test
////    void getPetsByBreed_ShouldReturnListOfPets() {
////        List<Pet> pets = new ArrayList<>();
////        pets.add(new Pet(1, "Buddy", "Dog", "Golden Retriever", 3));
////        when(petRepository.getPetsByBreed("Golden Retriever")).thenReturn(pets);
////
////        List<Pet> result = petService.getPetsByBreed("Golden Retriever");
////
////        assertNotNull(result);
////        assertEquals(1, result.size());
////        verify(petRepository, times(1)).getPetsByBreed("Golden Retriever");
////    }
////
////
////    @Test
////    void getPetStats_shouldReturnCorrectStats(){
////        PetStatDTO stats = new petStatsDTO(3.5, 5, 10);
////        when(petRepository.getPetStats().thenReturn(stats));
////
////        PetStatDTO res = petService.getPetStats();
////        assertNotNull(result);
////        assertEquals(3.5, result.getAverageAge());
////        assertEquals(5, result.getOldestAge());
////        assertEquals(10, result.getTotalCount());
////        verify(petRepository, times(1)).getPetStatistics();
////
////    }
//
//}
