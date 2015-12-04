package de.marco.test.jaxb;

import java.util.List;

public class PlannedObject {

    private Address adresse;
    private List<Address> additionalAdresses;

    public void setAdresse(final Address adresse) {
        this.adresse = adresse;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdditionalAdresses(final List<Address> additionalAdresses) {
        this.additionalAdresses = additionalAdresses;
    }

    public List<Address> getAdditionalAdresses() {
        return additionalAdresses;
    }

}
