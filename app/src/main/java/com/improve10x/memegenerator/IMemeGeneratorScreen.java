package com.improve10x.memegenerator;

public interface IMemeGeneratorScreen {
    void showScreen();

    void showTitle(String title);

    void showTemplateNamesDropDown();

    String getSelectedTemplateName();

    String getTopText();

    String getBottomText();

    void onGenerateMemeClicked();
}
