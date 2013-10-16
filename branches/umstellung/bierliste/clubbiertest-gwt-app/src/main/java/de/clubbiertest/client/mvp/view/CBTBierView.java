package de.clubbiertest.client.mvp.view;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.liste.shared.Bier;

public class CBTBierView extends AView {

    public class BierNotTestet extends FlowPanel {
        public BierNotTestet() {
            setStyleName(_css.infosection());
            final HTML val = new HTML(ClubbiertestTexte.TEXTE.nichtGetestet());
            val.setStyleName(_css.nottestet());
            add(val);
        }
    }

    public class BierInfoSection extends FlowPanel {
        public BierInfoSection(final String description, final Double value) {
            this(description, (((value != null) && (value > 0.0))) ? formatter.format(value) : null);
        }

        public BierInfoSection(final String description, final String value) {
            setStyleName(_css.infosection());
            final HTML desc = new HTML(description);
            desc.setStyleName(_css.description());
            add(desc);
            final HTML val = new HTML(value);
            val.setStyleName(_css.value());
            add(val);
            setVisible(value != null);
        }

    }

    private static final NumberFormat formatter = NumberFormat.getFormat("0.0");
    private final ClubbiertestCss _css;

    public CBTBierView(final ClubbiertestCss clubbiertestCss) {
        _css = clubbiertestCss;
        setStyleName(clubbiertestCss.bierInfo());
    }

    public void show(final Bier result) {
        clear();
        add(new BierInfoSection(ClubbiertestTexte.TEXTE.land(), result.getLand()));
        add(new BierInfoSection(ClubbiertestTexte.TEXTE.sorte(), result.getSorte()));
        add(new BierInfoSection(ClubbiertestTexte.TEXTE.name(), result.getName()));
        add(new BierInfoSection(ClubbiertestTexte.TEXTE.note(), result.getNote()));
        add(new BierInfoSection(ClubbiertestTexte.TEXTE.design(), result.getDesign()));
        if (result.getNote() <= 0) {
            add(new BierNotTestet());
        }

    }

}
