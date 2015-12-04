package de.marco.test;

public interface Wrapper<JAXB, DTO> {
    JAXB wrap(DTO dto);
}
