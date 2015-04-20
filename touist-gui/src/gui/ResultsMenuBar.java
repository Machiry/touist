/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.Locale;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author alexis
 */
public class ResultsMenuBar extends JMenuBar {
    
    MainFrame parent;
    JMenu jMenuFile;
    JMenu jMenuLanguage;
    JMenu jMenuHelp;
    JMenuItem jMenuItemEnglish;
    JMenuItem jMenuItemFrench;
    JMenuItem jMenuItemSaveModel;
    JMenuItem jMenuItemHelpResults;
    
    
    
    public ResultsMenuBar(MainFrame parent){
        this.parent = parent;
        jMenuFile = new JMenu();
        jMenuLanguage = new JMenu();
        jMenuHelp = new JMenu();
        
        jMenuItemEnglish = new JMenuItem("English");
        jMenuItemFrench = new JMenuItem("French");
        jMenuItemSaveModel = new JMenuItem();
        jMenuItemSaveModel.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        jMenuItemHelpResults = new JMenuItem();
        
        jMenuItemEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnglishActionPerformed(evt);
            }
        });
        
        jMenuItemFrench.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFrenchActionPerformed(evt);
            }
        });
        
        jMenuItemSaveModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveModelActionPerformed(evt);
            }
        });
        
        jMenuItemHelpResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpResultsActionPerformed(evt);
            }
        });
        
        jMenuFile.add(jMenuItemSaveModel);
        jMenuLanguage.add(jMenuItemFrench);
        jMenuLanguage.add(jMenuItemEnglish);
        jMenuHelp.add(jMenuItemHelpResults);
                
        this.add(jMenuFile);
        this.add(jMenuLanguage);
        this.add(jMenuHelp);
        
        updateLanguage();
        
    }
    
    private void jMenuItemEnglishActionPerformed(java.awt.event.ActionEvent evt) {
        parent.setLanguage(Locale.ENGLISH);
        parent.updateLanguage();
        System.out.println("Language set to ENGLISH");
    }                                           
    
    private void jMenuItemFrenchActionPerformed(java.awt.event.ActionEvent evt) { 
        parent.setLanguage(Locale.FRENCH);        
        parent.updateLanguage();
        System.out.println("Language set to FRENCH");
        
    }
    
    private void jMenuItemSaveModelActionPerformed(java.awt.event.ActionEvent evt) {  
        try {
            parent.getResultsPanel1().exportModel();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(parent.getResultsPanel1(), "Error during export","Export failure",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jMenuItemHelpResultsActionPerformed(java.awt.event.ActionEvent evt) {  
        
    }
    
    public void updateLanguage() {
        this.jMenuFile.setText(parent.getLang().getWord(Lang.FRAME_MENU_FILE));
        this.jMenuHelp.setText(parent.getLang().getWord(Lang.FRAME_MENU_HELP));
        this.jMenuLanguage.setText(parent.getLang().getWord(Lang.FRAME_MENU_LANGUAGE));
        this.jMenuItemSaveModel.setText(parent.getLang().getWord(Lang.RESULTS_MENUITEM_SAVEMODEL));
        this.jMenuItemHelpResults.setText(parent.getLang().getWord(Lang.RESULTS_MENUITEM_HELPRESULTS));
    }
    
}
