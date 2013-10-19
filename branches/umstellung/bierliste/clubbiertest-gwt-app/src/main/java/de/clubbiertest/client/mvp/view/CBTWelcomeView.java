package de.clubbiertest.client.mvp.view;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.msc.framework.client.mvp.AView;

import de.clubbiertest.client.ClubbiertestCss;
import de.clubbiertest.client.ClubbiertestResources;
import de.clubbiertest.client.ClubbiertestTexte;
import de.clubbiertest.client.WelcomeCss;

public class CBTWelcomeView extends AView {

    private final Anchor bestenListe;
    private final Anchor kontinente;

    public CBTWelcomeView(final ClubbiertestCss clubbiertestCss, final WelcomeCss welcomeCss) {
        setStyleName(clubbiertestCss.maincontent());
        final FlowPanel bildDescriptionContainer = new FlowPanel();
        bildDescriptionContainer.setStyleName(welcomeCss.willkommenfirst());
        add(bildDescriptionContainer);
        final FlowPanel bildContainer = new FlowPanel();
        bildContainer.setStyleName(welcomeCss.willkommenbild());
        final Image image = new Image(ClubbiertestResources.RESOURCES.anfang());
        bildContainer.add(image);
        bildDescriptionContainer.add(bildContainer);
        final HTML unabhaengig = new HTML(ClubbiertestTexte.TEXTE.unabhaengig());
        unabhaengig.setStyleName(welcomeCss.willkommenbildbeschriftung());
        bildDescriptionContainer.add(unabhaengig);
        final FlowPanel inputContainer = new FlowPanel();
        inputContainer.setStyleName(welcomeCss.willkommensecond());
        add(inputContainer);
        this.bestenListe = new Anchor("Bestenliste");
        add(bestenListe);
        this.kontinente = new Anchor("komplette Liste");
        add(kontinente);
    }

    public HandlerRegistration addBestenListeClickHandler(final ClickHandler handler) {
        return bestenListe.addClickHandler(handler);
    }

    public HandlerRegistration addKontinenteClickHandler(final ClickHandler handler) {
        return kontinente.addClickHandler(handler);
    }

}
