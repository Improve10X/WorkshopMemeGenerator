package com.improve10x.memegenerator;

public interface IMemeGeneratorScreen {
    void showTitle(String title);

    String getTemplateName();

    String getTopText();

    String getBottomText();

    void onGenerateMemeClicked();
}
