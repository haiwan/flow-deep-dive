package com.vaadin.flow.demo.helloworld.user;

import com.vaadin.data.Binder;
import com.vaadin.router.Route;
import com.vaadin.router.Title;
import com.vaadin.ui.Composite;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.formlayout.FormLayout;
import com.vaadin.ui.grid.Grid;
import com.vaadin.ui.html.Div;
import com.vaadin.ui.layout.FlexLayout.Alignment;
import com.vaadin.ui.layout.FlexLayout.JustifyContentMode;
import com.vaadin.ui.layout.HorizontalLayout;
import com.vaadin.ui.layout.VerticalLayout;
import com.vaadin.ui.textfield.TextField;

@Title("User")
@Route(value="user")
public class UserView extends Composite<Div> {

	public UserView() {
		FormLayout formLayout = new FormLayout();
		TextField firstNameField = new TextField();
		firstNameField.setLabel("First name");
		firstNameField.setPlaceholder("John");
		TextField lastNameField = new TextField();
		lastNameField.setLabel("Last name");
		lastNameField.setPlaceholder("Doe");
		TextField emailField = new TextField();
		emailField.setLabel("Email");
		emailField.setPlaceholder("john@mail.com");
		formLayout.add(firstNameField, lastNameField, emailField);

		Binder<User> binder = new Binder<>(User.class);
		binder.forField(firstNameField).bind(User::getFirstName, User::setFirstName);
		binder.forField(lastNameField).bind(User::getLastName, User::setLastName);
		binder.forField(emailField).bind(User::getEmail, User::setEmail);
		binder.readBean(null);

		VerticalLayout editLayout = new VerticalLayout();
		editLayout.add(formLayout);
		HorizontalLayout btnLayout = new HorizontalLayout();
		Button saveBtn = new Button("Save");
		Button cancelBtn = new Button("Cancel");
		btnLayout.add(saveBtn, cancelBtn);
		editLayout.add(btnLayout);

		HorizontalLayout rootLayout = new HorizontalLayout();
		rootLayout.setWidth("100%");

		Grid<User> userGrid = new Grid<>();
		userGrid.setItems(UserService.getAllUsers());
		userGrid.addColumn("First Name", User::getFirstName);
		userGrid.addColumn("Last Name", User::getLastName);
		userGrid.addColumn("Email", User::getEmail);

		rootLayout.add(userGrid, editLayout);
		rootLayout.setAlignItems(Alignment.START);
		rootLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
		userGrid.getElement().getStyle().set("width", "48%");
		editLayout.getElement().getStyle().set("width", "48%");

		getContent().add(rootLayout);



		userGrid.asSingleSelect().addValueChangeListener(e->{
			System.out.println("Hello Flow!");
			binder.readBean(e.getValue());
		});


	}


}
