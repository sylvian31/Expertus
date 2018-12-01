package com.expertus.expertusprojet.vaadin.ui;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.vaadin.view.AddProductView;
import com.expertus.expertusprojet.vaadin.view.DefaultView;
import com.expertus.expertusprojet.vaadin.view.GridProductView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyUI extends UI implements ViewDisplay {

	@Autowired
	Environment env;

	protected static final String MAINVIEW = "main";

	private HorizontalLayout horizontalLayoutForView;

	@Override
	protected void init(VaadinRequest pRequest) {

		final VerticalLayout lVerticalLayout = new VerticalLayout();
		final HorizontalLayout lHorizontalLayout = new HorizontalLayout();
		final Label lLabel = new Label("EXPERTUS");
		final CssLayout lNavigationBar = new CssLayout();
		horizontalLayoutForView = new HorizontalLayout();

		lVerticalLayout.addComponent(lHorizontalLayout);
		lVerticalLayout.addComponent(horizontalLayoutForView);
		lVerticalLayout.setExpandRatio(horizontalLayoutForView, 1.0f);

		lHorizontalLayout.addComponent(lLabel);
		lHorizontalLayout.addComponent(lNavigationBar);

		lNavigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		lNavigationBar.addComponent(createNavigationButton("Home", DefaultView.VIEW_NAME));
		lNavigationBar.addComponent(createNavigationButton("List product", GridProductView.VIEW_NAME));
		lNavigationBar.addComponent(createNavigationButton("Add product", AddProductView.VIEW_NAME));

		setContent(lVerticalLayout);
	}

	@Override
	public void showView(View pView) {
		horizontalLayoutForView.removeAllComponents();
		horizontalLayoutForView.addComponent((Component) pView);
	}

	private Button createNavigationButton(String pCaption, final String pViewName) {
		Button lButton = new Button(pCaption);
		lButton.addStyleName(ValoTheme.BUTTON_SMALL);
		lButton.addClickListener(event -> getUI().getNavigator().navigateTo(pViewName));
		return lButton;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}

// Set default view
//NavigationStateManager stateManager = new Navigator.UriFragmentManager(getPage());
//stateManager.setState(GridProductView.VIEW_NAME);
