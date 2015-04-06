/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.editionView;

import gui.AbstractComponentPanel;
import gui.editionView.editor.Editor;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javax.swing.JSplitPane;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author Skander
 */
public class EditionPanel extends AbstractComponentPanel {

    private Editor editorTextArea;
    private int rightPanelWidth;
    
    /**
     * Creates new form EditorPanel
     */
    public EditionPanel() {
        initComponents();
        // Editor textArea set-up
        try {
             editorTextArea = new Editor();
        }
        catch (IOException e) {
            System.err.println("Erreur lancement éditeur");
        }
        RTextScrollPane sp = new RTextScrollPane(editorTextArea);
        sp.setLineNumbersEnabled(true);
        sp.setFoldIndicatorEnabled(true);
        editorContainer.add(sp, BorderLayout.CENTER);
        
        palettePanel2.setEditorTextArea(editorTextArea);
        
        rightPanelWidth = jSplitPane1.getWidth() - jSplitPane1.getDividerLocation();
        
        jSplitPane1.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (jSplitPane1.getDividerLocation() < jSplitPane1.getWidth()) {
                    rightPanelWidth = jSplitPane1.getWidth() - jSplitPane1.getDividerLocation();
                    //when resizing the frame, the rightPanelWidth can end up < 0
                    //System.out.println(rightPanelWidth + " : " + evt);
                }
            }
        });
    }
    
    public void initPalette(PalettePanel.PaletteType type) {
        palettePanel2.initPaletteContent(type);
    }

    public String getText() {
        return editorTextArea.getText();
    }
    
    public void setText(String text) {
        editorTextArea.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        editorContainer = new javax.swing.JPanel();
        palettePanel2 = new gui.editionView.PalettePanel(editorTextArea);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane1.setOneTouchExpandable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel1);

        editorContainer.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setLeftComponent(editorContainer);

        jSplitPane2.setRightComponent(jSplitPane1);
        jSplitPane2.setLeftComponent(palettePanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jSplitPane1.setDividerLocation(jSplitPane1.getWidth() - rightPanelWidth);
    }//GEN-LAST:event_formComponentResized
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editorContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private gui.editionView.PalettePanel palettePanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateLanguage() {
        palettePanel2.updateLanguage();
    }
}
