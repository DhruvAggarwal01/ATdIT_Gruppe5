package test.listener;

import javax.swing.*;

import org.junit.*;

import listener.HyperlinkMouseAdapter;

public class HyperLinkMouseAdapterTest {
    
    JButton goToLinkButtonTest;

    @Test
    public void testRedirectOnClick(){
        goToLinkButtonTest = new JButton();
        goToLinkButtonTest.addMouseListener(new HyperlinkMouseAdapter(null));
        goToLinkButtonTest.doClick();
    }
}
