/*
 *
 * Project TouIST, 2015. Easily formalize and solve real-world sized problems
 * using propositional logic and linear theory of reals with a nice GUI.
 *
 * https://github.com/FredMaris/touist
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Alexis Comte, Abdelwahab Heba, Olivier Lezaud,
 *     Skander Ben Slimane, Maël Valais
 *
 */

package gui.editionView;

import entity.Model;
import gui.AbstractComponentPanel;
import gui.Lang;
import gui.MainFrame;
import gui.SolverSelection;
import gui.SolverSelection.SolverType;
import gui.State;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import solution.SolverExecutionException;
import solution.SolverSMT;
import solution.SolverTestSAT4J;
import translation.TranslationError;
import translation.TranslatorSAT;

/**
 *
 * @author Skander
 */
public class ParentEditionPanel extends AbstractComponentPanel {

    private static final int ERROR_MESSAGE_MAX_LENGTH = 60;
    private String jLabelErrorMessageText;
    private Thread testThread;

    /**
     * Creates new form FormulasPanel
     */
    public ParentEditionPanel() {
        initComponents();
        
        testThread = new Thread();
        
        editorPanelFormulas.initPalette(PalettePanel.PaletteType.FORMULA);
        editorPanelSets.initPalette(PalettePanel.PaletteType.SET);
        jFileChooser1.setCurrentDirectory(new File(".."));
        jLabelErrorMessageText = "";
        jLabelErrorMessage.setText(jLabelErrorMessageText);
        
        jComboBox1.removeAllItems();
        for (SolverType solverType : SolverSelection.SolverType.values()) {
            jComboBox1.addItem(solverType);
        }
    }
    
    public void updateComboBoxSelectedSolver() {
        jComboBox1.setSelectedItem(getFrame().getSolverSelection().getSelectedSolver());
    }
    
    /**
     * Update jLabelErrorMessage's text and keep it at ERROR_MESSAGE_MAX_LENGTH.
     * @param text The text used to set the label's text.
     */
    private void setJLabelErrorMessageText(String text) {
        jLabelErrorMessageText = text;
        if (text.length() < ERROR_MESSAGE_MAX_LENGTH) {
            jLabelErrorMessage.setText(text);
        } else {
            jLabelErrorMessage.setText(text.substring(0, ERROR_MESSAGE_MAX_LENGTH) + "...");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser(new File(System.getProperty("user.dir")));
        jOptionPane1 = new javax.swing.JOptionPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        editorPanelFormulas = new gui.editionView.EditionPanel();
        editorPanelSets = new gui.editionView.EditionPanel();
        testButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        jLabelErrorMessage = new javax.swing.JLabel();
        jLabelCaretPosition = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        exportButton = new javax.swing.JButton();

        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser1.addChoosableFileFilter(new FileNameExtensionFilter("Touistl files(touistl)","touistl"));

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addTab("Formulas", editorPanelFormulas);
        jTabbedPane1.addTab("Sets", editorPanelSets);

        testButton.setText("Solve");
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        jLabelErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorMessage.setText("<Error message>");
        jLabelErrorMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelErrorMessageMouseClicked(evt);
            }
        });

        jLabelCaretPosition.setText("1:1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAT", "SMT" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCaretPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testButton)
                    .addComponent(importButton)
                    .addComponent(jLabelCaretPosition)
                    .addComponent(jLabelErrorMessage)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        switch(((MainFrame)(getRootPane().getParent())).state) {
            case EDITION :
                setState(State.EDITION);
                importHandler();
                break;
            case EDITION_ERROR :
                setState(State.EDITION_ERROR);
                importHandler();
                break;
            case NO_RESULT :
                // impossible
                break;
            case SINGLE_RESULT :
                // impossible
                break;
            case FIRST_RESULT :
                // impossible
                break;
            case MIDDLE_RESULT :
                // impossible
                break;
            case LAST_RESULT :
                // impossible
                break;
            default : 
                System.out.println("Undefined action set for the state : " + getState());
        }
    }//GEN-LAST:event_importButtonActionPerformed

    /**
     * For Java RE 6 compatibility (p.isAlive() is JavaRE7)
     */
	private boolean isAlive(Process process) {
	    try {
	        process.exitValue();
	        return false;
	    } catch (Exception e) {
	        return true;
	    }
	}
    
	private boolean isStopInsteadOfTest = false;
    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        switch(((MainFrame)(getRootPane().getParent())).state) {
            case EDITION :
                setJLabelErrorMessageText("");
                
                this.testButton.setText(isStopInsteadOfTest
                		?getFrame().getLang().getWord("ParentEditionPanel.testButton.text")
                		:getFrame().getLang().getWord("ParentEditionPanel.stopButton.text"));
                isStopInsteadOfTest = (isStopInsteadOfTest)?false:true;
                
                if(testThread.isAlive()) {
                    testThread.interrupt();
                }
                
                Process p = null;
                
                if (getFrame().getSolverSelection().getSelectedSolver() == SolverSelection.SolverType.SAT) {
                    p = getFrame().getTranslatorSAT().getP();
                } else {
                    p = getFrame().getTranslatorSMT().getP();                    
                }
                
                if(p != null && isAlive(p)){
                    p.destroy();
                }

                if(!isStopInsteadOfTest)
                        break;

                Runnable r = new Runnable() {
                    public void run() {
                        State state = initResultView();
                        testButton.setText(getFrame().getLang().getWord("ParentEditionPanel.testButton.text"));
                        isStopInsteadOfTest = false;
                        if (state != State.EDITION) {
                            setState(state);
                            getFrame().setViewToResults();
                        }
                    }
                };

                testThread = new Thread(r);
                testThread.start();
                break;
            case EDITION_ERROR :
                // interdit
                break;
            case NO_RESULT :
                // impossible
                break;
            case SINGLE_RESULT :
                // impossible
                break;
            case FIRST_RESULT :
                // impossible
                break;
            case MIDDLE_RESULT :
                // impossible
                break;
            case LAST_RESULT :
                // impossible
                break;
            default : 
                System.out.println("Undefined action set for the state : " + getState());
        }
    }//GEN-LAST:event_testButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        switch(((MainFrame)(getRootPane().getParent())).state) {
            case EDITION :
                setState(State.EDITION);
                exportHandler();
                break;
            case EDITION_ERROR :
                setState(State.EDITION_ERROR);
                exportHandler();
                break;
            case NO_RESULT :
                // impossible
                break;
            case SINGLE_RESULT :
                // impossible
                break;
            case FIRST_RESULT :
                // impossible
                break;
            case MIDDLE_RESULT :
                // impossible
                break;
            case LAST_RESULT :
                // impossible
                break;
            default : 
                System.out.println("Undefined action set for the state : " + getState());
        }    }//GEN-LAST:event_exportButtonActionPerformed

    private void jLabelErrorMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelErrorMessageMouseClicked
        if (jLabelErrorMessageText.length() > ERROR_MESSAGE_MAX_LENGTH) {
            JOptionPane.showMessageDialog(this,
                    jLabelErrorMessageText, 
                    getFrame().getLang().getWord(Lang.ERROR_MESSAGE_TITLE), 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelErrorMessageMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            if (jComboBox1.getSelectedItem() instanceof SolverType) {
                getFrame().getSolverSelection().setSelectedSolver((SolverType)(jComboBox1.getSelectedItem()));
            }
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.editionView.EditionPanel editorPanelFormulas;
    private gui.editionView.EditionPanel editorPanelSets;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton importButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabelCaretPosition;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton testButton;
    // End of variables declaration//GEN-END:variables

    public void importHandler() {
        String path = getFrame().getDefaultDirectoryPath();
        int returnVal;
        getFrame().getClause().setFormules("");
        getFrame().getClause().setSets("");
        
        returnVal = jFileChooser1.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION && jFileChooser1.getSelectedFile() != null) {
            path = jFileChooser1.getSelectedFile().getPath();

            try {
                getFrame().getClause().uploadFile(path);
            } catch(Exception e) {
                //TODO handle error message
                System.out.println("Error : Failed to load the file : " + path);
                e.printStackTrace();
            }

            //Réinitialisation des sets et des formules
            String text = getFrame().getClause().getFormules();
            editorPanelFormulas.setText(text);
            text = getFrame().getClause().getSets();
            editorPanelSets.setText(text);
        }   
    }
    
    public void exportHandler() {
        getFrame().getClause().setFormules("");
        getFrame().getClause().setSets("");
        getFrame().getClause().addFormules(editorPanelFormulas.getText());
        getFrame().getClause().addSets(editorPanelSets.getText());
        
        int returnVal = jFileChooser1.showDialog(this,getFrame().getLang().getWord(Lang.EDITION_FILE_CHOOSER));
        try {
            if(returnVal == JFileChooser.APPROVE_OPTION){
                getFrame().getClause().saveToFile(jFileChooser1.getSelectedFile().getPath());
            }
        } catch (IOException e) {
            String warningWindowTitle = getFrame().getLang().getWord(Lang.EDITION_EXPORT_FAILURE_TITLE);
            String warningWindowText = getFrame().getLang().getWord(Lang.EDITION_EXPORT_FAILURE_TEXT);
            JOptionPane.showMessageDialog(this,warningWindowText,warningWindowTitle,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showErrorMessage(String message, String title) {
        jOptionPane1.showMessageDialog(getParent(), 
                        message, 
                        title, 
                        JOptionPane.ERROR_MESSAGE);
    }
    
    private void showErrorMessage(Exception e, String message, String title) {
        showErrorMessage(message, title);
        
        /*
         * To enable the exceptions stacks to be filed into log.txt, I added 
         * a system property "debug" that must be added when calling java:
         *     java -Ddebug=true -jar touist.jar
         * 
         * Or you can simply run `ant run`, it will enable that flag.
         */
        if(System.getProperty("debug") == "true") {
        	FileWriter writer = null;
        	String texte = String.valueOf(e.getStackTrace()) + "\n" + "######################";
        	try{
        		writer = new FileWriter("log.txt", true);
        		writer.write(texte,0,texte.length());
        	}catch(IOException ex){
        		ex.printStackTrace();
        	}finally{
        		if(writer != null){
        			try {
        				writer.close();
        			} catch (IOException ex) {
        				e.printStackTrace();
        			}
          }
        }
        }
    }
    
    private TranslationError guiTranslationErrorAdapter(TranslationError error) {
        TranslatorSAT t = new TranslatorSAT("");
        TranslationError adaptedError;
        int row = error.getRowInCode();
        String sets = getFrame().getClause().getSets();
        int nbRowsInSets = 1;
        int setShift = (getFrame().getClause().getSets().isEmpty()) ? 0 : -1; // -1 pour tenir compte de "begin sets";
        int formulasShift = (getFrame().getClause().getSets().isEmpty()) ? 0 : -3; // -3 pour tenir compte de "begin sets", "end sets" et "begin formulas"
        
        for (int i=0; i<sets.length(); i++) {
            if (sets.charAt(i) == '\n') {
                nbRowsInSets++;
            }
        }
        if (row < nbRowsInSets) {
            // l'erreur est dans les sets
            adaptedError = new TranslationError(row - setShift,
                    error.getColumnInCode(), 
                    error.getErrorMessage() + getFrame().getLang().getWord(Lang.ERROR_TRADUCTION_IN_SETS));
        } else {
            // l'erreur est dans les formules
            adaptedError = new TranslationError(row-nbRowsInSets - formulasShift, 
                    error.getColumnInCode(), 
                    error.getErrorMessage() + getFrame().getLang().getWord(Lang.ERROR_TRADUCTION_IN_FORMULAS));
        }
        return adaptedError;
    }

    private State initResultView() {
        // Initialisation de BaseDeClause
        getFrame().getClause().setFormules("");
        getFrame().getClause().setSets("");
        getFrame().getClause().addFormules(editorPanelFormulas.getText());
        getFrame().getClause().addSets(editorPanelSets.getText());
        
        /*
        Faire appel au solveur avec les fichiers générés par le traducteur
        calculer un model
        Si un model suivant existe
        alors passer a l'état FIRST_RESULT
        sinon passer à l'état SINGLE_RESULT
        Si aucun model n'existe alors passer a l'état NO_RESULT
        */
        String bigAndFilePath = "temp.touistl"; //TODO se mettre d'accord sur un nom standard ou ajouter a Translator et BaseDeClause des méthode pour s'échange de objets File
        String errorMessage;
        
        
        try {
            getFrame().getClause().saveToFile(bigAndFilePath);
        } catch (IOException ex) {
            ex.printStackTrace();
            errorMessage = "Couldn't create file '" + bigAndFilePath + "'";
            showErrorMessage(errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
            System.exit(0);
            return State.EDITION;
        }
        
        if (getFrame().getSolverSelection().getSelectedSolver() == SolverSelection.SolverType.SAT) {
           
            try {
                if(! getFrame().getTranslatorSAT().translate(bigAndFilePath)) {
                    errorMessage = "";
                    for (TranslationError error : getFrame().getTranslatorSAT().getErrors()) {
                            if(error.hasRowAndColumn()) {
                                    errorMessage += guiTranslationErrorAdapter(error) + "\n";
                            } else { 
                                    errorMessage += error + "\n";
                            }
                    }
                    setJLabelErrorMessageText(errorMessage);

                    System.out.println("Traduction error : " + "\n" + errorMessage + "\n");
                    /*uncomment the following line to have a popup once an error is detected*/
                    //showErrorMessage(errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                    return State.EDITION;
                }
                File f = new File(bigAndFilePath);
                f.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
                errorMessage = "The translator returned an IOException: \n"+ex.getMessage()+"\nCheck that touistc is in external/ and that it has the right permissions.";
                showErrorMessage(ex, errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                return State.EDITION;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                errorMessage = "Translator has been interrupted.";
                showErrorMessage(ex, errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                return State.EDITION;
            }

            //Add CurrentPath/dimacsFile
            String translatedFilePath = getFrame().getTranslatorSAT().getDimacsFilePath();
            Map<Integer, String> literalsMap = getFrame().getTranslatorSAT().getLiteralsMap();
            getFrame().setSolver(new SolverTestSAT4J(translatedFilePath, literalsMap));

            try {
                getFrame().getSolver().launch();
            } catch (IOException ex) {
                ex.printStackTrace();
                errorMessage = "Couldn't launch solver.";
                showErrorMessage(ex, errorMessage, "Solver error");
                return State.EDITION;
            }    

            // Si il y a au moins un model
            try {
                ListIterator<Model> iter = getFrame().getSolver().getModelList().iterator();
                if(!iter.hasNext()) {
                    System.out.println("This problem is unsatisfiable");
                    errorMessage = "There is no solution";
                    showErrorMessage(errorMessage, "Solver error");
                    return State.EDITION;
                }    
                getFrame().updateResultsPanelIterator(iter);
                /**
                 * Si il y a plus d'un model, alors passer à l'état FIRST_RESULT
                 * sinon passer à l'état SINGLE_RESULT
                 */
                if (iter.hasNext()) {
                    getFrame().setResultView(iter.next());
                    if (iter.hasNext()) {
                       //iter.previous();
                        return State.FIRST_RESULT;
                    } else {
                        //iter.previous();
                        return State.SINGLE_RESULT;
                    }
                } else {
                    return State.SINGLE_RESULT;
                }
            } catch (SolverExecutionException ex) {
                ex.printStackTrace();
                errorMessage = "The solver encountered a problem.";
                showErrorMessage(ex, errorMessage, "Solver error");
                return State.EDITION;
            }
        } else {
            try {
                String logic = "";
                switch(getFrame().getSolverSelection().getSelectedSolver()) {
                    case QF_IDL : 
                        logic = "QF_IDL";
                        break;
                    case QF_LIA :
                        logic = "QF_LIA";
                        break;
                    case QF_LRA :
                        logic = "QF_LRA";
                        break;
                    case QF_RDL :
                        logic = "QF_RDL";
                        break;
                    default :
                }
                
                if(! getFrame().getTranslatorSMT().translate(bigAndFilePath, logic)) {
                    errorMessage = "";
                    for (TranslationError error : getFrame().getTranslatorSAT().getErrors()) {
                            if(error.hasRowAndColumn()) {
                                    errorMessage += guiTranslationErrorAdapter(error) + "\n";
                            } else { 
                                    errorMessage += error + "\n";
                            }
                    }
                    setJLabelErrorMessageText(errorMessage);

                    System.out.println("Traduction error : " + "\n" + errorMessage + "\n");
                    /*uncomment the following line to have a popup once an error is detected*/
                    //showErrorMessage(errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                    return State.EDITION;
                }
                File f = new File(bigAndFilePath);
                f.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
                errorMessage = "The translator returned an IOException: \n"+ex.getMessage();
                showErrorMessage(ex, errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                return State.EDITION;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                errorMessage = "Translator has been interrupted.";
                showErrorMessage(ex, errorMessage, getFrame().getLang().getWord(Lang.ERROR_TRADUCTION));
                return State.EDITION;
            }
            try {
                System.out.println(getFrame().getTranslatorSMT().getSMTFilePath());
                getFrame().setSolver(new SolverSMT(getFrame().getTranslatorSMT().getSMTFilePath()));
                //appel lors de la réussit du traducteur
                Model model = ((SolverSMT)(getFrame().getSolver())).getresult();
                System.out.println("eoo le model : "+model.toString());
                getFrame().setResultView(model);
                return State.SINGLE_RESULT;
            } catch (Exception e) {
                //TODO handle exceptions
                
            }
        }
        
        return State.EDITION;
    }
    
    public void setJLabelCaretPositionText(String text) {
        jLabelCaretPosition.setText(text);
    }

    public void undo() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_Z);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_Z);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    public void redo() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_Y);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_Y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    public void zoom(int n) {
        if(jTabbedPane1.getSelectedIndex() <= 1) {
            ((EditionPanel)jTabbedPane1.getSelectedComponent()).zoom(n);
        }
    }
    
    @Override
    public void updateLanguage() {
        jTabbedPane1.setToolTipText("");
        importButton.setText(getFrame().getLang().getWord(Lang.EDITION_IMPORT));
        importButton.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.importButton.tooltip"));
        exportButton.setText(getFrame().getLang().getWord(Lang.EDITION_EXPORT));
        exportButton.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.exportButton.tooltip"));
        testButton.setText(getFrame().getLang().getWord(Lang.EDITION_TEST));
        testButton.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.testButton.tooltip")); 
        editorPanelFormulas.updateLanguage();
        editorPanelSets.updateLanguage();
        jTabbedPane1.setTitleAt(0, getFrame().getLang().getWord(Lang.EDITION_TAB_FORMULAS));
        jTabbedPane1.setTitleAt(1, getFrame().getLang().getWord(Lang.EDITION_TAB_SETS));
        jTabbedPane1.setToolTipTextAt(0, getFrame().getLang().getWord("ParentEditionPanel.editorPanelFormulas.TabConstraints.tabTooltip"));
        jTabbedPane1.setToolTipTextAt(1, getFrame().getLang().getWord("ParentEditionPanel.editorPanelSets.TabConstraints.tabTooltip"));
        jComboBox1.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.comboBoxSATSMT.tooltip"));
        jLabelCaretPosition.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.jLabelCaretPosition.tooltip"));
        jLabelErrorMessage.setToolTipText(getFrame().getLang().getWord("ParentEditionPanel.jLabelErrorMessage.tooltip"));
        updateUI();
    }
}
