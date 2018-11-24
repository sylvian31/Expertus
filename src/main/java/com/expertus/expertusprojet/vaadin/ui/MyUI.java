package com.expertus.expertusprojet.vaadin.ui;

import com.expertus.expertusprojet.Language;
import com.expertus.expertusprojet.vaadin.view.ProductView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyUI extends UI implements ViewDisplay {

	private Panel springViewDisplay;

	@Override
	protected void init(VaadinRequest pRequest) {
		final VerticalLayout lVerticalLayout = new VerticalLayout();
		lVerticalLayout.setSizeFull();
		setContent(lVerticalLayout);
		lVerticalLayout.addComponent(new Label(Language.getLanguageHeaderTitre()));

		final CssLayout lNavigationBar = new CssLayout();
		lNavigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		lNavigationBar.addComponent(createNavigationButton("View Scoped View", ProductView.VIEW_NAME));
		lNavigationBar.addComponent(createNavigationButton("UI Scoped View", UIScopedView.VIEW_NAME));
		lVerticalLayout.addComponent(lNavigationBar);

		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		lVerticalLayout.addComponent(springViewDisplay);
		lVerticalLayout.setExpandRatio(springViewDisplay, 1.0f);

	}

	private Button createNavigationButton(String pCaption, final String pViewName) {
		Button lButton = new Button(pCaption);
		lButton.addStyleName(ValoTheme.BUTTON_SMALL);
		// If you didn't choose Java 8 when creating the project, convert this
		// to an anonymous listener class
		lButton.addClickListener(event -> getUI().getNavigator().navigateTo(pViewName));
		return lButton;
	}

	@Override
	public void showView(View pView) {
		springViewDisplay.setContent((Component) pView);
	}

}
