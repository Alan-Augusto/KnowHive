package tests.entities;

import domain.entities.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TagTeste {

    @Test
    void getNome() {
        Tag tag = new Tag();
        tag.setNome("Tag 1");
        assertEquals("Tag 1", tag.getNome());
    }

    @Test
    void setNome() {
        Tag tag = new Tag();
        tag.setNome("Tag 2");
        assertEquals("Tag 2", tag.getNome());
    }
}
