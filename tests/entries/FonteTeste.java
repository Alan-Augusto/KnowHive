package domain.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FonteTeste {

    @Test
    void getTexto() {
        Fonte fonte = new Fonte();
        fonte.setTexto("Texto fonte 1");
        assertEquals("Texto fonte 1", fonte.getTexto());
    }

    @Test
    void setTexto() {
        Fonte fonte = new Fonte();
        fonte.setTexto("Texto fonte 2");
        assertEquals("Texto fonte 2", fonte.getTexto());
    }

    @Test
    void getDescricao() {
        Fonte fonte = new Fonte();
        fonte.setDescricao("Descricao fonte 1");
        assertEquals("Descricao fonte 1", fonte.getDescricao());
    }

    @Test
    void setDescricao() {
        Fonte fonte = new Fonte();
        fonte.setDescricao("Descricao fonte 2");
        assertEquals("Descricao fonte 2", fonte.getDescricao());
    }
}
