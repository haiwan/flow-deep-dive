/*
 * Copyright 2000-2017 Vaadin Ltd.
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
package com.vaadin.flow.demo.helloworld;

import com.vaadin.flow.demo.helloworld.card.CardMakerTemplate;
import com.vaadin.flow.demo.helloworld.user.UserView;
import com.vaadin.flow.router.View;
import com.vaadin.router.Route;
import com.vaadin.router.RouterLayout;
import com.vaadin.router.RouterLink;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.html.Div;
import com.vaadin.ui.html.H1;
import com.vaadin.ui.layout.VerticalLayout;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("frontend://styles.html")
@Route("")
public class MainView extends VerticalLayout implements RouterLayout{

    public MainView() {
        add(new H1("Flow Deep Dive"));
        Div naviBar = new Div();
        naviBar.add(new RouterLink("User", UserView.class));
        naviBar.add(new RouterLink("Card", CardMakerTemplate.class));
        add(naviBar);
    }

}
