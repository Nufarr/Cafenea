import Clase.Cafenea;
import Enum.Locatie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCafenea {
    @Test
    void testEsteDeschisaAcum() {
        Cafenea cafenea = new Cafenea("Starbucks", Locatie.Pipera, "07:00-21:00");
        assertTrue(cafenea.esteDeschisaAcum("08:00"));   //deschis
        assertTrue(cafenea.esteDeschisaAcum("13:00"));   //deschis
        assertTrue(cafenea.esteDeschisaAcum("07:00"));   //fix cand se deschide
        assertTrue(cafenea.esteDeschisaAcum("07.20"));   //deschis
        assertFalse(cafenea.esteDeschisaAcum("02:00"));  //prea devreme
        assertFalse(cafenea.esteDeschisaAcum("22:00"));  //prea tarziu
        assertFalse(cafenea.esteDeschisaAcum("21:00"));  //inchide la ora
    }
}
