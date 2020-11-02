package listener;

import javax.swing.*;

import org.junit.*;

import atdit1.group5.listener.HyperlinkMouseAdapter;

public class HyperLinkMouseAdapterTest {

    JButton goToLinkButtonTest;

    //Checks if the HyperLinkAdapter is implemented correctly
    @Test
    public void testRedirectOnClick() {
        goToLinkButtonTest = new JButton();
        goToLinkButtonTest.addMouseListener(new HyperlinkMouseAdapter(null));
        goToLinkButtonTest.doClick();
    }
}
