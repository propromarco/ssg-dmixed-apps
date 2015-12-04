package de.marco.test.generated;

import java.util.ArrayList;
import java.util.List;

import de.marco.test.Wrapper;
import de.marco.test.dto.AdresseDto;
import de.marco.test.dto.Form1Dto;
import de.marco.test.jaxb.Address;
import de.marco.test.jaxb.FormularI;
import de.marco.test.jaxb.PlannedObject;

public class Form1DtoWrapper implements Wrapper<FormularI, Form1Dto> {

    @Override
    public FormularI wrap(final Form1Dto dto) {
        final FormularI main = new FormularI();
        if (dto.getName() != null) { // Simple
            final String a = dto.getName();
            main.setTitle(a);
        }
        if (dto.getMainAdresse() != null) { // Complex
            final PlannedObject a = ensureObject(main);
            final AdresseDto b = dto.getMainAdresse();
            final Address c = new AdresseDtoWrapper().wrap(b);
            a.setAdresse(c);
        }
        if (dto.getZusatzAdressen() != null && !dto.getZusatzAdressen().isEmpty()) { // List
            final PlannedObject a = ensureObject(main);
            final List<Address> b = ensureAdditionalAdresses(a);
            final List<AdresseDto> c = dto.getZusatzAdressen();
            for (final AdresseDto d : c) {
                final Address e = new AdresseDtoWrapper().wrap(d);
                b.add(e);
            }
        }
        return main;
    }

    private List<Address> ensureAdditionalAdresses(final PlannedObject object) {
        if (object.getAdditionalAdresses() == null) {
            final List<Address> a = new ArrayList<Address>();
            object.setAdditionalAdresses(a);
        }
        return object.getAdditionalAdresses();
    }

    private PlannedObject ensureObject(final FormularI main) {
        if (main.getObject() == null) {
            final PlannedObject a = new PlannedObject();
            main.setObject(a);
        }
        return main.getObject();
    }

}
