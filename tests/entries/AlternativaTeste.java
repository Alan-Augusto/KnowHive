import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlternativaTeste {

    @Test
    void getTexto() {
        Alternativa alternativa = new Alternativa();
        alternativa.setTexto("Teste 1");
        assertEquals("Teste 1", alternativa.getTexto());
    }

    @Test
    void setTexto() {
        Alternativa alternativa = new Alternativa();
        alternativa.setTexto("Teste 2");
        assertEquals("Teste 2", alternativa.getTexto());
    }

    @Test
    void isCorreta() {
        Alternativa alternativa = new Alternativa();
        alternativa.setCorreta(true);
        assertTrue(alternativa.isCorreta());
    }

    @Test
    void setCorreta() {
        Alternativa alternativa = new Alternativa();
        alternativa.setCorreta(false);
        assertFalse(alternativa.isCorreta());
    }
}
