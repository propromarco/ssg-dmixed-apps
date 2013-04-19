/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.appspot.ssg.dmixed.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 * 
 */
public class TerminPlace extends Place {

    private final Long _termin;

    public static class TerminePlaceTokenizer implements PlaceTokenizer<TerminPlace> {

        @Override
        public TerminPlace getPlace(final String token) {
            return new TerminPlace();
        }

        @Override
        public String getToken(final TerminPlace place) {
            return "Termin";
        }

    }

    public TerminPlace() {
        this(null);
    }

    public TerminPlace(final Long terminId) {
        _termin = terminId;
    }

    public Long getTermin() {
        return _termin;
    }

    @Override
    public int hashCode() {
        return 4;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;

        if (other instanceof TerminPlace)
            return true;
        return false;
    }
}
