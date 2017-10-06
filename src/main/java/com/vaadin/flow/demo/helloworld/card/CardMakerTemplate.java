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
package com.vaadin.flow.demo.helloworld.card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.vaadin.flow.demo.helloworld.MainView;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.model.TemplateModel;
import com.vaadin.router.Route;
import com.vaadin.ui.Tag;
import com.vaadin.ui.checkbox.Checkbox;
import com.vaadin.ui.combobox.ComboBox;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.polymertemplate.Id;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

/**
 * Simple template example.
 */
@Tag("card-maker")
@HtmlImport("frontend://CardMakerTemplate.html")
@Route(value = "card")
public class CardMakerTemplate extends PolymerTemplate<TemplateModel> {

    @Id("symbol")
    private ComboBox<String> symbol;

    @Id("rank")
    private ComboBox<String> rank;

    @Id("flippable")
    private Checkbox flippable;

    @Id("card")
    private Element card;


    public CardMakerTemplate() {
        symbol.setLabel("Symbol");
        symbol.setItems(Arrays.asList("♠", "♥", "♦", "♣"));

        rank.setLabel("Rank");
        List<String> rankValues = IntStream.range(1, 10).mapToObj(String::valueOf).collect(Collectors.toList());
        rankValues.addAll(Arrays.asList("j", "q", "k"));
        rank.setItems(rankValues);

        flippable.setLabel("Flippable");

        //Binder<CardConfig> binder = new Binder<>(CardConfig.class);
        symbol.setRequired(true);
        rank.setRequired(true);
        symbol.addValueChangeListener(e->card.setProperty("symbol", e.getValue()==null?"":e.getValue()));
        rank.addValueChangeListener(e->card.setProperty("rank", e.getValue()==null?"":e.getValue()));
        flippable.addValueChangeListener(e->{
            if(e.getValue()){
                card.setProperty("flippable", "true");
            }else{
                card.removeProperty("flippable");
            }
        });
    }

}
