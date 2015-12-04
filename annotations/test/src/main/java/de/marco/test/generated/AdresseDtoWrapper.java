package de.marco.test.generated;

import de.marco.test.Wrapper;
import de.marco.test.dto.AdresseDto;
import de.marco.test.jaxb.Address;

public class AdresseDtoWrapper implements Wrapper<Address, AdresseDto> {

    public Address wrap(final AdresseDto dto) {
        final Address main = new Address();
        if (dto.getStrasse() != null) { // Simple
            final String a = dto.getStrasse();
            main.setStrasse(a);
        }
        return main;
    }

}
