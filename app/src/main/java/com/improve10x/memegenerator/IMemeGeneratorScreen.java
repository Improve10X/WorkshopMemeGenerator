package com.improve10x.memegenerator;

public interface IMemeGeneratorScreen {
    void showScreen();

    void showTitle(String title);

    void hideTemplateNameTxt();

    void showTemplateNamesDropDown();

    void showTemplateNames(String[] templateNames);

    String getSelectedTemplateName();

    String getTopText();

    String getBottomText();

    void onGenerateMemeClicked();
}
