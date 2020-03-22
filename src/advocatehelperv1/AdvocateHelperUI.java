//
// Decompiled by Procyon v0.5.36
//

package advocatehelperv1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.beans.PropertyChangeEvent;
import java.io.OutputStream;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import java.math.BigInteger;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import net.miginfocom.swing.MigLayout;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.util.regex.Matcher;
import javax.swing.table.TableModel;
import java.beans.PropertyChangeListener;
import javax.swing.text.JTextComponent;
import java.math.RoundingMode;

import dbhelper.DBHandler;

import java.util.HashMap;
import javax.swing.text.MaskFormatter;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import dbhelper.DocumentList;
import dbhelper.AabadiProperty;
import dbhelper.Property;
import dbhelper.SearchMaster;
import dbhelper.ApplicantInfo;
import dbhelper.ChannelHistory;
import java.util.ArrayList;

public class AdvocateHelperUI extends JFrame
{
    String selectedAdvocate;
    String selectedBank;
    String selectedBranch;
    String selectedMortgagedWith;
    String selectedSearchType;
    String selectedFh;
    Cursor wait;
    Cursor def;
    JDialog dialog;
    DefaultListModel<String> modelDocumentList;
    ArrayList<ChannelHistory> channelHistories;
    ApplicantInfo applicantInfo;
    SearchMaster searchMaster;
    ArrayList<Property> properties;
    AabadiProperty aabadiProperty;
    ArrayList<DocumentList> documentLists;
    DefaultTableModel model;
    boolean alreadyMortgaged;
    DecimalFormat df;
    DecimalFormat df2;
    DecimalFormat df3;
    DecimalFormat df4;
    DefaultComboBoxModel<String> cmbModel;
    String sizeRegex;
    String periodRegex;
    Pattern ptSize;
    Pattern ptPeriod;
    SimpleDateFormat sdf;
    MaskFormatter dateMask;
    MaskFormatter samwatMask;
    String tsrPeriod;
    int tsrYear;
    String[] heldBys;
    String heldByStr;
    String propertyAddr;
    String totalShare;
    String khasraNos;
    String khataNos;
    String jamabandiSmts;
    String jamadts;
    String girdawariSmts;
    String girddts;
    String tldates;
    String villages;
    String patwariAreas;
    String patwariVillages;
    String states;
    String districts;
    String tehsils;
    String chains;
    String pathPrefix;
    String lastFile;
    String villageAabadi;
    String tehsilAabadi;
    String districtAabadi;
    String stateAabadi;
    String khasraAabadi;
    String pattaAabadi;
    String missalAabadi;
    String bookAabadi;
    String sizeAabadi;
    String eastAabadi;
    String westAabadi;
    String northAabadi;
    String southAabadi;
    String dlcAabadi;
    String chainAabadi;
    String availableDocsAabadi;
    String availableDocsOriginalAabadi;
    String conversionOrderDateAabadi;
    String fullDetailOfDocumentsAabadi;
    String lastSaleDeedDate;
    String aabadiDocsDate;
    String receiptAabadi;
    String aabadiHoldBy;
    String lastSaleDeedIssuedByAabadi;
    String conversionOrderIssuedByAabadi;
    String aabadiFirstDate;
    String aabadiFirstIssuedBy;
    HashMap<String, HashMap<String, ArrayList<String[]>>> pnbTable1;
    FocusListener highlighter;
    String totalSize;
    double totalAcres;
    int totalDLC;
    double totalHect;
    double hectPercent;
    double appShareHect;
    int shareTotalBigha;
    int shareTotalBishwa;
    int totalBigha;
    int totalBishwa;
    DBHandler dbHandler;
    private JButton btn_addChain;
    private JButton btn_addDocumentAabadi;
    private JButton btn_addProperty;
    private JButton btn_clear;
    private JButton btn_print;
    private JButton btn_removeLastChain;
    private JButton btn_save;
    private JButton btn_viewListDocumentAabadi;
    private JComboBox<String> combo_advocate;
    private JComboBox<String> combo_bank;
    private JComboBox<String> combo_branch;
    private JComboBox<String> combo_deedNature;
    private JComboBox<String> combo_documentType;
    private JComboBox<String> combo_fh;
    private JComboBox<String> combo_heldBy;
    private JComboBox<String> combo_issuedBy;
    private JComboBox<String> combo_issuedTo;
    private JComboBox<String> combo_landType;
    private JComboBox<String> combo_mortgagedWith;
    private JComboBox<String> combo_ownerShare;
    private JComboBox<String> combo_requiredAabadi;
    private JComboBox<String> combo_searchType;
    private JComboBox<String> combo_share;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel6;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel65;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JPopupMenu.Separator jSeparator1;
    private JLabel lbl_logo;
    private JList<String> list_documents;
    private JMenuItem menu_copySearch;
    private JMenuItem menu_edit;
    private JMenuItem menu_editSearch;
    private JMenuItem menu_remove;
    private JMenuItem menu_removeDocumentList;
    private JMenuItem menu_search;
    private JCheckBoxMenuItem menu_switchToAabadi;
    private JPanel panelAabadi;
    private JPanel panelApplicantInfo;
    private JPanel panelButtons;
    private JPanel panelDocumentList;
    private JPanel panelMainNew;
    private JPanel panelNormal;
    private JPanel panelPropertyAndChain;
    private JPanel panelSearchInfo;
    private JPanel panelTable;
    private JPanel panel_main;
    private JPopupMenu popup;
    private JPopupMenu popup_documentList;
    private JTable tab_properties;
    private JTextField txt_address;
    private JTextField txt_age;
    private JTextField txt_bookNo;
    private JTextField txt_calculatedShare;
    private JTextField txt_cast;
    private JTextArea txt_chain;
    private JTextArea txt_chainAabadi;
    private JTextField txt_channelKhasra;
    private JTextField txt_channelSize;
    private JTextField txt_date;
    private JTextField txt_deedExecutionDate;
    private JTextField txt_district;
    private JTextField txt_districtAabadi;
    private JTextField txt_dlc;
    private JTextField txt_dlcAabadi;
    private JTextField txt_documentNoAabadi;
    private JTextField txt_east;
    private JTextField txt_fhName;
    private JFormattedTextField txt_girdawari;
    private JTextField txt_historyName;
    private JTextField txt_issuedByAabadi;
    private JTextField txt_issuedDateAabadi;
    private JTextField txt_issuedToAabadi;
    private JFormattedTextField txt_jamabandi;
    private JTextField txt_khasraNo;
    private JTextField txt_khasraNoAabadi;
    private JTextField txt_khataNo;
    private JTextField txt_missalNo;
    private JTextField txt_mortgagedBank;
    private JTextField txt_mortgagedBranch;
    private JTextField txt_name;
    private JTextField txt_north;
    private JTextField txt_pattaNo;
    private JTextField txt_patwariArea;
    private JTextField txt_patwariVillage;
    private JTextField txt_receiptNumberAabadi;
    private JTextField txt_refNo;
    private JTextField txt_registerDate;
    private JFormattedTextField txt_samwatAabadi;
    private JTextField txt_searchPeriod;
    private JTextField txt_size;
    private JTextField txt_sizeAabadi;
    private JTextField txt_sno;
    private JTextField txt_south;
    private JTextField txt_state;
    private JTextField txt_stateAabadi;
    private JTextField txt_subRegistrar;
    private JTextField txt_tehsil;
    private JTextField txt_tehsilAabadi;
    private JFormattedTextField txt_tldate;
    private JTextField txt_village;
    private JTextField txt_villageAabadi;
    private JTextField txt_west;

    public AdvocateHelperUI() {
        this.alreadyMortgaged = false;
        this.sizeRegex = "\\b([0-9]{1,5}[-]{1}[0-9]{2}[,]?)+?";
        this.periodRegex = "\\b([0-9]{4}[-]{1}[0-9]{4})";
        this.ptSize = Pattern.compile(this.sizeRegex);
        this.ptPeriod = Pattern.compile(this.periodRegex);
        this.tsrPeriod = "";
        this.propertyAddr = "";
        this.totalShare = "";
        this.khasraNos = "";
        this.khataNos = "";
        this.jamabandiSmts = "";
        this.jamadts = "";
        this.girdawariSmts = "";
        this.girddts = "";
        this.tldates = "";
        this.villages = "";
        this.patwariAreas = "";
        this.patwariVillages = "";
        this.states = "";
        this.districts = "";
        this.tehsils = "";
        this.chains = "";
        this.pathPrefix = "";
        this.lastFile = "";
        this.highlighter = null;
        this.totalSize = "";
        this.totalAcres = 0.0;
        this.totalDLC = 0;
        this.totalHect = 0.0;
        this.hectPercent = 0.0;
        this.appShareHect = 0.0;
        this.shareTotalBigha = 0;
        this.shareTotalBishwa = 0;
        this.totalBigha = 0;
        this.totalBishwa = 0;
        try {
            this.dbHandler = DBHandler.getInstance();
            this.checkValidUser();
            (this.dateMask = new MaskFormatter("##/##/####")).setPlaceholderCharacter(' ');
            this.dateMask.setValidCharacters("0123456789");
            this.dateMask.setOverwriteMode(true);
            (this.samwatMask = new MaskFormatter("##/##/####_####-####")).setPlaceholderCharacter(' ');
            this.samwatMask.setValidCharacters("0123456789");
            this.samwatMask.setOverwriteMode(true);
            this.initComponents();
            this.txt_girdawari.setCaretPosition(0);
            this.modelDocumentList = new DefaultListModel<String>();
            this.list_documents.setModel(this.modelDocumentList);
            this.wait = new Cursor(3);
            this.def = Cursor.getDefaultCursor();
            this.channelHistories = new ArrayList<ChannelHistory>();
            this.aabadiProperty = new AabadiProperty();
            this.properties = new ArrayList<Property>();
            this.documentLists = new ArrayList<DocumentList>();
            this.applicantInfo = new ApplicantInfo();
            this.searchMaster = new SearchMaster();
            this.model = (DefaultTableModel)this.tab_properties.getModel();
            (this.df = new DecimalFormat("#.##")).setRoundingMode(RoundingMode.DOWN);
            (this.df2 = new DecimalFormat("##")).setRoundingMode(RoundingMode.DOWN);
            (this.df3 = new DecimalFormat("#.##")).setRoundingMode(RoundingMode.HALF_DOWN);
            (this.df4 = new DecimalFormat("##")).setRoundingMode(RoundingMode.HALF_UP);
            this.cmbModel = (DefaultComboBoxModel<String>)(DefaultComboBoxModel)this.combo_share.getModel();
            final JTextComponent editor = (JTextComponent)this.combo_share.getEditor().getEditorComponent();
            editor.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent e) {
                    System.out.println("lost");
                    Object item = AdvocateHelperUI.this.combo_share.getSelectedItem();
                    if (item != null) {
                        String size = item.toString();
                        if (!size.isEmpty() && !size.equalsIgnoreCase("calculate") && !size.equalsIgnoreCase("calculated")) {
                            String str = (String)item;
                            if (str.contains("/")) {
                                AdvocateHelperUI.this.combo_share.setSelectedIndex(0);
                            } else {
                                if (!str.contains("-")) {
                                    AdvocateHelperUI.this.combo_share.getToolkit().beep();
                                    return;
                                }

                                AdvocateHelperUI.this.combo_share.setSelectedIndex(1);
                            }

                            AdvocateHelperUI.this.calculateShare();
                        }
                    }
                }
            });
            editor.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    System.out.println("KeyCode " + e.getKeyCode());
                    if (e.getKeyCode() != 38 && e.getKeyCode() != 40) {
                        String str = editor.getText().trim().toLowerCase();
                        System.out.println(str);
                        if (str.endsWith("calculate") || str.endsWith("calculated")) {
                            str = str.replaceAll(" calculated", "");
                            str = str.replaceAll(" calculate", "");
                        }

                        AdvocateHelperUI.this.cmbModel.removeAllElements();
                        if (str.length() != 0) {
                            AdvocateHelperUI.this.cmbModel.addElement(str.replaceAll("-", "/") + " calculate");
                            AdvocateHelperUI.this.cmbModel.addElement(str.replaceAll("/", "-") + " calculated");
                        }

                        editor.setText(str);
                    } else {
                        super.keyReleased(e);
                    }

                }

                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ((c < '0' || c > '9') && c != '\n' && c != '\b' && c != '/' && c != 'o' && c != '&' && c != '(' && c != '-' && c != 'm' && c != 127) {
                        AdvocateHelperUI.this.getToolkit().beep();
                        e.consume();
                    }

                    String str = editor.getText().trim().toLowerCase();
                    if (c == '\b') {
                        if (str.endsWith("calculate") || str.endsWith("calculated")) {
                            str = str.replaceAll(" calculated", "");
                            str = str.replaceAll(" calculate", "");
                            editor.setText(str);
                        }

                        System.out.println("Length " + str.length());
                        if (str.length() == 0) {
                            AdvocateHelperUI.this.cmbModel.removeAllElements();
                        }
                    } else if (c == '\n') {
                        if (str.contains("/")) {
                            AdvocateHelperUI.this.combo_share.setSelectedIndex(0);
                        } else {
                            if (!str.contains("-")) {
                                AdvocateHelperUI.this.combo_share.getToolkit().beep();
                                return;
                            }

                            AdvocateHelperUI.this.combo_share.setSelectedIndex(1);
                        }
                    }

                }
            });
            this.selectedAdvocate = this.combo_advocate.getSelectedItem().toString();
            this.selectedBank = this.combo_bank.getSelectedItem().toString();
            this.selectedBranch = this.combo_branch.getSelectedItem().toString();
            this.selectedMortgagedWith = this.combo_mortgagedWith.getSelectedItem().toString();
            this.selectedSearchType = this.combo_searchType.getSelectedItem().toString();
            this.selectedFh = this.combo_fh.getSelectedItem().toString();
            this.enableChain();
            this.sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.createOutputFolders();
            this.clearAll();
            final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.showNormal();
            final KeyboardFocusManager kbfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            kbfm.addPropertyChangeListener(new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent e) {
                    String properties = e.getPropertyName();
                    Component component;
                    String name;
                    JComboBox cmb;
                    if ("focusOwner".equals(properties) && e.getNewValue() != null) {
                        component = (Component)e.getNewValue();
                        name = component.getClass().getName();
                        if (!name.equals("javax.swing.JComboBox")) {
                            component.setBackground(Color.MAGENTA);
                        } else {
                            cmb = (JComboBox)component;
                            cmb.setRenderer(new DefaultListCellRenderer() {
                                public void paint(Graphics g) {
                                    this.setForeground(Color.MAGENTA);
                                    super.paint(g);
                                }
                            });
                        }
                    } else if (e.getOldValue() != null) {
                        component = (Component)e.getOldValue();
                        name = component.getClass().getName();
                        if (!name.equals("javax.swing.JComboBox")) {
                            component.setBackground(UIManager.getColor("TextField.background"));
                        } else {
                            cmb = (JComboBox)component;
                            cmb.setRenderer(new DefaultListCellRenderer() {
                                public void paint(Graphics g) {
                                    this.setForeground(Color.BLACK);
                                    super.paint(g);
                                }
                            });
                        }
                    }

                }
            });
            this.setLocation((int)((screenSize.getWidth() - this.getWidth()) / 2.0), (int)((screenSize.getHeight() - this.getHeight()) / 2.0));
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in starting application because of " + e.getMessage() + ", please close all resources and try again.", "Error", 0);
            System.exit(0);
        }
    }

    private void initComponents() {
        this.popup = new JPopupMenu();
        this.menu_edit = new JMenuItem();
        this.menu_remove = new JMenuItem();
        this.panelAabadi = new JPanel();
        this.jLabel31 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel38 = new JLabel();
        this.txt_villageAabadi = new JTextField();
        this.jLabel39 = new JLabel();
        this.txt_tehsilAabadi = new JTextField();
        this.jLabel40 = new JLabel();
        this.txt_districtAabadi = new JTextField();
        this.jLabel41 = new JLabel();
        this.txt_stateAabadi = new JTextField();
        this.jLabel42 = new JLabel();
        this.txt_pattaNo = new JTextField();
        this.jLabel43 = new JLabel();
        this.txt_missalNo = new JTextField();
        this.jLabel44 = new JLabel();
        this.txt_khasraNoAabadi = new JTextField();
        this.jLabel45 = new JLabel();
        this.txt_bookNo = new JTextField();
        this.jLabel46 = new JLabel();
        this.txt_sizeAabadi = new JTextField();
        this.jLabel47 = new JLabel();
        this.txt_east = new JTextField();
        this.jLabel48 = new JLabel();
        this.txt_west = new JTextField();
        this.jLabel49 = new JLabel();
        this.txt_north = new JTextField();
        this.jLabel50 = new JLabel();
        this.txt_south = new JTextField();
        this.jLabel61 = new JLabel();
        this.txt_dlcAabadi = new JTextField();
        this.txt_receiptNumberAabadi = new JTextField();
        this.jLabel62 = new JLabel();
        this.jLabel52 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jLabel53 = new JLabel();
        this.combo_documentType = new JComboBox<String>();
        this.txt_issuedByAabadi = new JTextField();
        this.jLabel54 = new JLabel();
        this.txt_issuedDateAabadi = new JTextField();
        this.txt_issuedToAabadi = new JTextField();
        this.txt_documentNoAabadi = new JTextField();
        this.jLabel56 = new JLabel();
        this.jLabel57 = new JLabel();
        this.txt_samwatAabadi = new JFormattedTextField();
        this.jLabel58 = new JLabel();
        this.combo_requiredAabadi = new JComboBox<String>();
        this.btn_addDocumentAabadi = new JButton();
        this.btn_viewListDocumentAabadi = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.txt_chainAabadi = new JTextArea();
        this.jLabel65 = new JLabel();
        this.combo_issuedBy = new JComboBox<String>();
        this.combo_issuedTo = new JComboBox<String>();
        this.jLabel51 = new JLabel();
        this.txt_registerDate = new JTextField();
        this.panelMainNew = new JPanel();
        this.panelNormal = new JPanel();
        this.panelSearchInfo = new JPanel();
        this.jPanel15 = new JPanel();
        this.jPanel5 = new JPanel();
        this.jLabel1 = new JLabel();
        this.txt_sno = new JTextField();
        this.jLabel2 = new JLabel();
        this.combo_advocate = new JComboBox<String>();
        this.combo_bank = new JComboBox<String>();
        this.combo_branch = new JComboBox<String>();
        this.jLabel3 = new JLabel();
        this.combo_searchType = new JComboBox<String>();
        this.combo_mortgagedWith = new JComboBox<String>();
        this.jLabel4 = new JLabel();
        this.txt_mortgagedBank = new JTextField();
        this.jLabel5 = new JLabel();
        this.txt_mortgagedBranch = new JTextField();
        this.txt_searchPeriod = new JTextField();
        this.jLabel6 = new JLabel();
        this.txt_subRegistrar = new JTextField();
        this.jLabel7 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel34 = new JLabel();
        this.txt_refNo = new JTextField();
        this.txt_date = new JTextField();
        this.jPanel17 = new JPanel();
        this.lbl_logo = new JLabel();
        this.panelPropertyAndChain = new JPanel();
        this.jLabel13 = new JLabel();
        this.jPanel6 = new JPanel();
        this.jLabel14 = new JLabel();
        this.combo_heldBy = new JComboBox<String>();
        this.jLabel16 = new JLabel();
        this.txt_village = new JTextField();
        this.jLabel17 = new JLabel();
        this.txt_district = new JTextField();
        this.jLabel18 = new JLabel();
        this.txt_state = new JTextField();
        this.jLabel19 = new JLabel();
        this.txt_khasraNo = new JTextField();
        this.jLabel20 = new JLabel();
        this.txt_size = new JTextField();
        this.jLabel15 = new JLabel();
        this.combo_landType = new JComboBox<String>();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.txt_khataNo = new JTextField();
        this.jLabel24 = new JLabel();
        this.txt_dlc = new JTextField();
        this.jLabel25 = new JLabel();
        this.txt_patwariVillage = new JTextField();
        this.jLabel26 = new JLabel();
        this.txt_patwariArea = new JTextField();
        this.combo_ownerShare = new JComboBox<String>();
        this.combo_share = new JComboBox<String>();
        this.jLabel27 = new JLabel();
        this.txt_calculatedShare = new JTextField();
        this.jLabel32 = new JLabel();
        this.txt_tehsil = new JTextField();
        this.btn_addProperty = new JButton();
        this.txt_jamabandi = new JFormattedTextField(this.samwatMask);
        this.jLabel59 = new JLabel();
        this.txt_girdawari = new JFormattedTextField(this.samwatMask);
        this.txt_tldate = new JFormattedTextField(this.dateMask);
        this.jPanel7 = new JPanel();
        this.jLabel28 = new JLabel();
        this.txt_historyName = new JTextField();
        this.combo_deedNature = new JComboBox<String>();
        this.jLabel29 = new JLabel();
        this.txt_deedExecutionDate = new JTextField();
        this.btn_addChain = new JButton();
        this.btn_removeLastChain = new JButton();
        this.jLabel36 = new JLabel();
        this.txt_channelKhasra = new JTextField();
        this.jLabel37 = new JLabel();
        this.txt_channelSize = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txt_chain = new JTextArea();
        this.jLabel30 = new JLabel();
        this.jLabel35 = new JLabel();
        this.panelTable = new JPanel();
        this.jPanel13 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.tab_properties = new JTable();
        this.panelApplicantInfo = new JPanel();
        this.jLabel8 = new JLabel();
        this.jPanel16 = new JPanel();
        this.jLabel12 = new JLabel();
        this.combo_fh = new JComboBox<String>();
        this.txt_cast = new JTextField();
        this.jLabel11 = new JLabel();
        this.txt_age = new JTextField();
        this.txt_age.setVisible(false);
        this.jLabel9 = new JLabel();
        this.txt_fhName = new JTextField();
        this.txt_name = new JTextField();
        this.jLabel33 = new JLabel();
        this.txt_address = new JTextField();
        this.panelDocumentList = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.list_documents = new JList<String>();
        this.jLabel60 = new JLabel();
        this.popup_documentList = new JPopupMenu();
        this.menu_removeDocumentList = new JMenuItem();
        this.panelButtons = new JPanel();
        this.jPanel14 = new JPanel();
        this.btn_save = new JButton();
        this.btn_clear = new JButton();
        this.btn_print = new JButton();
        this.panel_main = new JPanel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu2 = new JMenu();
        this.menu_editSearch = new JMenuItem();
        this.menu_copySearch = new JMenuItem();
        this.jSeparator1 = new JPopupMenu.Separator();
        this.menu_search = new JMenuItem();
        this.menu_switchToAabadi = new JCheckBoxMenuItem();
        this.menu_edit.setText("Edit");
        this.menu_edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_editActionPerformed(evt);
            }
        });
        this.popup.add(this.menu_edit);
        this.menu_remove.setText("Remove");
        this.menu_remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_removeActionPerformed(evt);
            }
        });
        this.popup.add(this.menu_remove);
        this.panelAabadi.setBackground(new Color(255, 255, 204));
        this.panelAabadi.setPreferredSize(new Dimension(848, 315));
        this.jLabel31.setBackground(new Color(197, 217, 241));
        this.jLabel31.setFont(new Font("Tahoma", 1, 11));
        this.jLabel31.setHorizontalAlignment(0);
        this.jLabel31.setText("<HTML><U>Property Information</U></HTML>");
        this.jLabel31.setOpaque(true);
        this.jPanel1.setBackground(new Color(197, 217, 241));
        this.jLabel38.setText("Village");
        this.jLabel39.setText("Tehsil");
        this.jLabel40.setText("District");
        this.txt_districtAabadi.setText("Jodhpur");
        this.jLabel41.setText("State");
        this.txt_stateAabadi.setText("Rajasthan");
        this.jLabel42.setText("Patta No");
        this.jLabel43.setText("Missal No");
        this.jLabel44.setText("Khasra No");
        this.jLabel45.setText("Book No");
        this.jLabel46.setText("Measurement(Size)");
        this.jLabel47.setText("MAP - EAST");
        this.jLabel48.setText("MAP - WEST");
        this.jLabel49.setText("MAP - NORTH");
        this.jLabel50.setText("MAP - SOUTH");
        this.jLabel61.setText("DLC Calculated");
        this.jLabel62.setText("Receipt Number");
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel38, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_villageAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel39, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_tehsilAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel40, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_districtAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel41, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_stateAabadi, -2, 94, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel44, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_khasraNoAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel42, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_pattaNo, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel43, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_missalNo, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel45, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_bookNo, -2, 94, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel46, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_sizeAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel47, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_east, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel48, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_west, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel49, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_north, -2, 94, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel50, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_south, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel61, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_dlcAabadi, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel62, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_receiptNumberAabadi, -2, 94, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(13, 13, 13).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel38).addComponent(this.txt_villageAabadi, -2, -1, -2).addComponent(this.jLabel39).addComponent(this.txt_tehsilAabadi, -2, -1, -2).addComponent(this.jLabel40).addComponent(this.txt_districtAabadi, -2, -1, -2).addComponent(this.jLabel41).addComponent(this.txt_stateAabadi, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel44).addComponent(this.txt_khasraNoAabadi, -2, -1, -2).addComponent(this.jLabel42).addComponent(this.txt_pattaNo, -2, -1, -2).addComponent(this.jLabel43).addComponent(this.txt_missalNo, -2, -1, -2).addComponent(this.jLabel45).addComponent(this.txt_bookNo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel46).addComponent(this.txt_sizeAabadi, -2, -1, -2).addComponent(this.jLabel47).addComponent(this.txt_east, -2, -1, -2).addComponent(this.jLabel48).addComponent(this.txt_west, -2, -1, -2).addComponent(this.jLabel49).addComponent(this.txt_north, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel50).addComponent(this.txt_south, -2, -1, -2).addComponent(this.jLabel61).addComponent(this.txt_dlcAabadi, -2, -1, -2).addComponent(this.txt_receiptNumberAabadi, -2, -1, -2).addComponent(this.jLabel62)).addContainerGap(-1, 32767)));
        this.jLabel52.setBackground(new Color(197, 217, 241));
        this.jLabel52.setFont(new Font("Tahoma", 1, 11));
        this.jLabel52.setHorizontalAlignment(0);
        this.jLabel52.setText("<HTML><U>Documents List</U></HTML>");
        this.jLabel52.setOpaque(true);
        this.jPanel3.setBackground(new Color(197, 217, 241));
        this.jLabel53.setText("Name of Document");
        this.combo_documentType.setEditable(true);
        this.combo_documentType.setModel(new DefaultComboBoxModel<String>(new String[] { "Conversion Order", "PATTA", "Jamabandi", "Sale Deed", "Gift Deed", "Court Order", "NOC" }));
        this.jLabel54.setText("Date");
        this.jLabel56.setText("Document Number");
        this.jLabel57.setText("Samwat");
        this.jLabel58.setText("Required ?");
        this.combo_requiredAabadi.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes -  Original", "Yes - Photo Copy", "Yes - Duplicate", "Yes - Self Attested", "Yes - Certified Copy", "No" }));
        this.btn_addDocumentAabadi.setText("Add");
        this.btn_addDocumentAabadi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_addDocumentAabadiActionPerformed(evt);
            }
        });
        this.btn_viewListDocumentAabadi.setText("View List");
        this.btn_viewListDocumentAabadi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_viewListDocumentAabadiActionPerformed(evt);
            }
        });
        this.txt_chainAabadi.setEditable(false);
        this.txt_chainAabadi.setColumns(20);
        this.txt_chainAabadi.setRows(1);
        this.txt_chainAabadi.setWrapStyleWord(true);
        this.jScrollPane4.setViewportView(this.txt_chainAabadi);
        this.jLabel65.setHorizontalAlignment(0);
        this.jLabel65.setText("<HTML><CENTER>Channel History</CENTER></HTML>");
        this.combo_issuedBy.setModel(new DefaultComboBoxModel<String>(new String[] { "Issued By", "Executed By" }));
        this.combo_issuedTo.setModel(new DefaultComboBoxModel<String>(new String[] { "Issued To", "Executed To", "In Favour of" }));
        this.jLabel51.setText("Registered Date");
        final GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel53, -1, 96, 32767).addComponent(this.jLabel56, -1, -1, 32767).addComponent(this.jLabel65)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txt_documentNoAabadi).addComponent(this.combo_documentType, 0, 144, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel57, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_samwatAabadi, -2, 114, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.combo_issuedBy, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_issuedByAabadi, -2, 79, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel54, -1, 55, 32767).addComponent(this.jLabel58, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_issuedDateAabadi, -1, 91, 32767).addComponent(this.combo_requiredAabadi, 0, 1, 32767)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.combo_issuedTo, -2, -1, -2)).addGroup(jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel51, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_issuedToAabadi, -1, 134, 32767).addComponent(this.txt_registerDate))).addComponent(this.jScrollPane4, -2, 708, -2).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.btn_addDocumentAabadi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btn_viewListDocumentAabadi))).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel53).addComponent(this.combo_documentType, -2, -1, -2).addComponent(this.txt_issuedByAabadi, -2, -1, -2).addComponent(this.jLabel54).addComponent(this.txt_issuedDateAabadi, -2, -1, -2).addComponent(this.txt_issuedToAabadi, -2, -1, -2).addComponent(this.combo_issuedBy, -2, -1, -2).addComponent(this.combo_issuedTo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_documentNoAabadi, -2, -1, -2).addComponent(this.jLabel56).addComponent(this.jLabel57).addComponent(this.txt_samwatAabadi, -2, -1, -2).addComponent(this.jLabel58).addComponent(this.combo_requiredAabadi, -2, -1, -2).addComponent(this.jLabel51).addComponent(this.txt_registerDate, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btn_addDocumentAabadi).addComponent(this.btn_viewListDocumentAabadi)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel65).addComponent(this.jScrollPane4, -1, 35, 32767)).addGap(3, 3, 3)));
        final GroupLayout panelAabadiLayout = new GroupLayout(this.panelAabadi);
        this.panelAabadi.setLayout(panelAabadiLayout);
        panelAabadiLayout.setHorizontalGroup(panelAabadiLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAabadiLayout.createSequentialGroup().addContainerGap().addGroup(panelAabadiLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel52).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jLabel31, GroupLayout.Alignment.LEADING, -1, 828, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        panelAabadiLayout.setVerticalGroup(panelAabadiLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelAabadiLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel31, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel52, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
        final GroupLayout panelMainNewLayout = new GroupLayout(this.panelMainNew);
        this.panelMainNew.setLayout(panelMainNewLayout);
        panelMainNewLayout.setHorizontalGroup(panelMainNewLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        panelMainNewLayout.setVerticalGroup(panelMainNewLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        final GroupLayout panelNormalLayout = new GroupLayout(this.panelNormal);
        this.panelNormal.setLayout(panelNormalLayout);
        panelNormalLayout.setHorizontalGroup(panelNormalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        panelNormalLayout.setVerticalGroup(panelNormalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        this.panelSearchInfo.setBackground(new Color(255, 255, 204));
        this.jPanel15.setBackground(new Color(255, 255, 204));
        this.jPanel5.setBackground(new Color(197, 217, 241));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("SNO");
        this.txt_sno.setEditable(false);
        this.txt_sno.setFocusable(false);
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Date");
        this.combo_advocate.setModel(new DefaultComboBoxModel<String>(new String[] { "Chandan Singh Bhati", "Parvat Singh Bhati" }));
        this.combo_advocate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_advocateActionPerformed(evt);
            }
        });
        this.combo_bank.setModel(new DefaultComboBoxModel<String>(new String[] { "Select Bank", "BOB", "ICICI", "OBC", "PNB", "SBI", "RMGB", "UCO", "UNION", "AXIS", "AUFINANCE", "BOI", "HDFC", "INDUSIND" }));
        this.combo_bank.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_bankActionPerformed(evt);
            }
        });
        this.combo_branch.setEditable(true);
        this.combo_branch.setModel(new DefaultComboBoxModel<String>(new String[] { "Osian", "Baori", "Mathaniya", "Tinwari", "Jelu Gagari", "Jodhpur", "Nevra Road" }));
        this.combo_branch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_branchActionPerformed(evt);
            }
        });
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Search Type");
        this.combo_searchType.setModel(new DefaultComboBoxModel<String>(new String[] { "Fresh", "Mortgaged" }));
        this.combo_searchType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_searchTypeActionPerformed(evt);
            }
        });
        this.combo_mortgagedWith.setModel(new DefaultComboBoxModel<String>(new String[] { "With Same Bank", "With Other Bank" }));
        this.combo_mortgagedWith.setEnabled(false);
        this.combo_mortgagedWith.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_mortgagedWithActionPerformed(evt);
            }
        });
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("Morgaged Bank");
        this.txt_mortgagedBank.setEnabled(false);
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("Morgaged Branch");
        this.txt_mortgagedBranch.setEnabled(false);
        this.txt_searchPeriod.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                AdvocateHelperUI.this.txt_searchPeriodFocusLost(evt);
            }
        });
        this.jLabel6.setHorizontalAlignment(0);
        this.jLabel6.setText("Sub Registrar");
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("Search Period");
        this.jLabel10.setHorizontalAlignment(0);
        this.jLabel10.setText("Adv.");
        this.jLabel34.setHorizontalAlignment(0);
        this.jLabel34.setText("Ref No");
        final GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_sno, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_date, -1, 68, 32767)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 65, -2).addGap(1, 1, 1).addComponent(this.combo_searchType, -2, -1, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel34, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_refNo))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.combo_mortgagedWith, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel4, -1, -1, 32767).addComponent(this.jLabel6, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_mortgagedBank, -2, 98, -2).addComponent(this.txt_subRegistrar, -2, 98, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 87, -2).addComponent(this.jLabel5, -2, 85, -2))).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel10, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.combo_advocate, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.combo_bank, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.combo_branch, 0, 100, 32767).addComponent(this.txt_mortgagedBranch).addComponent(this.txt_searchPeriod, -1, 100, 32767)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.combo_branch).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txt_sno, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.combo_advocate, -2, -1, -2).addComponent(this.combo_bank, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.txt_date, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.combo_searchType, -2, -1, -2).addComponent(this.combo_mortgagedWith, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.txt_mortgagedBank, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.txt_mortgagedBranch, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_searchPeriod, -2, -1, -2).addComponent(this.jLabel6, -2, 14, -2).addComponent(this.txt_subRegistrar, -2, -1, -2).addComponent(this.jLabel7).addComponent(this.jLabel34).addComponent(this.txt_refNo, -2, -1, -2)).addContainerGap()));
        final GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
        this.jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 677, 32767).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addContainerGap(-1, 32767))));
        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 116, 32767).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel5, -2, -1, -2).addContainerGap())));
        this.jPanel17.setBackground(new Color(255, 153, 255));
        final GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
        this.jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lbl_logo, GroupLayout.Alignment.TRAILING, -2, 155, -2));
        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addComponent(this.lbl_logo, -2, 94, -2).addGap(0, 0, 32767)));
        final GroupLayout panelSearchInfoLayout = new GroupLayout(this.panelSearchInfo);
        this.panelSearchInfo.setLayout(panelSearchInfoLayout);
        panelSearchInfoLayout.setHorizontalGroup(panelSearchInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelSearchInfoLayout.createSequentialGroup().addComponent(this.jPanel15, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel17, -1, -1, 32767).addContainerGap()));
        panelSearchInfoLayout.setVerticalGroup(panelSearchInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelSearchInfoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel15, -2, -1, -2)).addGroup(panelSearchInfoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel17, -1, -1, 32767).addContainerGap()));
        this.panelPropertyAndChain.setBackground(new Color(255, 255, 204));
        this.jLabel13.setBackground(new Color(197, 217, 241));
        this.jLabel13.setFont(new Font("Tahoma", 1, 11));
        this.jLabel13.setHorizontalAlignment(0);
        this.jLabel13.setText("<HTML><U>Property Information</U></HTML>");
        this.jLabel13.setOpaque(true);
        this.jPanel6.setBackground(new Color(197, 217, 241));
        this.jLabel14.setHorizontalAlignment(0);
        this.jLabel14.setText("Held By");
        this.combo_heldBy.setModel(new DefaultComboBoxModel<String>(new String[] { "Ancestral", "Self-Acquired" }));
        this.combo_heldBy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_heldByActionPerformed(evt);
            }
        });
        this.jLabel16.setHorizontalAlignment(0);
        this.jLabel16.setText("Village");
        this.txt_village.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                AdvocateHelperUI.this.txt_villageFocusLost(evt);
            }
        });
        this.jLabel17.setHorizontalAlignment(0);
        this.jLabel17.setText("District");
        this.txt_district.setText("Jodhpur");
        this.jLabel18.setHorizontalAlignment(0);
        this.jLabel18.setText("State");
        this.txt_state.setText("Rajasthan");
        this.jLabel19.setHorizontalAlignment(0);
        this.jLabel19.setText("Khasra");
        this.jLabel20.setHorizontalAlignment(0);
        this.jLabel20.setText("Size");
        this.txt_size.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                AdvocateHelperUI.this.txt_sizeFocusLost(evt);
            }
        });
        this.jLabel15.setHorizontalAlignment(0);
        this.jLabel15.setText("Land Type");
        this.combo_landType.setModel(new DefaultComboBoxModel<String>(new String[] { "Agriculture", "Individual", "Commercial", "Industrial" }));
        this.jLabel21.setHorizontalAlignment(0);
        this.jLabel21.setText("Jamabandi");
        this.jLabel22.setHorizontalAlignment(0);
        this.jLabel22.setText("TLDate");
        this.jLabel23.setHorizontalAlignment(0);
        this.jLabel23.setText("Khata No");
        this.jLabel24.setHorizontalAlignment(0);
        this.jLabel24.setText("DLC per Bigha");
        this.jLabel25.setHorizontalAlignment(0);
        this.jLabel25.setText("Pat Village");
        this.jLabel26.setHorizontalAlignment(0);
        this.jLabel26.setText("Pat Area");
        this.combo_ownerShare.setModel(new DefaultComboBoxModel<String>(new String[] { "Exculsive", "Share" }));
        this.combo_ownerShare.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                AdvocateHelperUI.this.combo_ownerShareFocusLost(evt);
            }
        });
        this.combo_ownerShare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_ownerShareActionPerformed(evt);
            }
        });
        this.combo_share.setEditable(true);
        this.combo_share.setEnabled(false);
        this.jLabel27.setHorizontalAlignment(0);
        this.jLabel27.setText("Calculated Sh");
        this.txt_calculatedShare.setEnabled(false);
        this.jLabel32.setHorizontalAlignment(0);
        this.jLabel32.setText("Tehsil");
        this.btn_addProperty.setText("Add Property");
        this.btn_addProperty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_addPropertyActionPerformed(evt);
            }
        });
        this.txt_jamabandi.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                AdvocateHelperUI.this.txt_jamabandiFocusGained(evt);
            }
        });
        this.jLabel59.setHorizontalAlignment(0);
        this.jLabel59.setText("Girdawari");
        this.txt_girdawari.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                AdvocateHelperUI.this.txt_girdawariFocusGained(evt);
            }
        });
        final GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel21, -1, -1, 32767).addComponent(this.jLabel19, -1, -1, 32767).addComponent(this.jLabel14, -1, -1, 32767)).addComponent(this.jLabel25)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_khasraNo, -2, 190, -2).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.combo_heldBy, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel16, -2, 39, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_village, -2, 59, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel32).addGap(18, 18, 18).addComponent(this.txt_tehsil, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel17, -2, 43, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_district, -2, 117, -2)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel20, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_size, -2, 306, -2)))).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_jamabandi, -2, 189, -2).addComponent(this.txt_patwariVillage, -2, 189, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel26, GroupLayout.Alignment.TRAILING, -2, 55, -2).addComponent(this.jLabel22, GroupLayout.Alignment.TRAILING, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_patwariArea, -1, 103, 32767).addComponent(this.txt_tldate)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel23, GroupLayout.Alignment.TRAILING, -2, 67, -2).addComponent(this.combo_ownerShare, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.combo_share, 0, 119, 32767).addComponent(this.txt_khataNo)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel18, -1, -1, 32767).addComponent(this.jLabel15, -1, -1, 32767).addComponent(this.jLabel24, -1, -1, 32767).addComponent(this.jLabel27, -2, 74, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_state).addComponent(this.combo_landType, 0, -1, 32767).addComponent(this.txt_dlc).addComponent(this.txt_calculatedShare, -2, 100, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.jLabel59, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_girdawari, -2, 189, -2).addGap(219, 219, 219).addComponent(this.btn_addProperty, -2, 345, -2))).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.combo_heldBy, -2, -1, -2).addComponent(this.jLabel16).addComponent(this.txt_village, -2, -1, -2).addComponent(this.jLabel17).addComponent(this.txt_district, -2, -1, -2).addComponent(this.jLabel18).addComponent(this.txt_state, -2, -1, -2).addComponent(this.jLabel32).addComponent(this.txt_tehsil, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.txt_khasraNo, -2, -1, -2).addComponent(this.jLabel20).addComponent(this.txt_size, -2, -1, -2).addComponent(this.jLabel15).addComponent(this.combo_landType, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.jLabel22).addComponent(this.jLabel23).addComponent(this.txt_khataNo, -2, -1, -2).addComponent(this.jLabel24).addComponent(this.txt_dlc, -2, -1, -2).addComponent(this.txt_jamabandi, -2, -1, -2).addComponent(this.txt_tldate, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_patwariVillage, -2, -1, -2).addComponent(this.jLabel25).addComponent(this.jLabel26).addComponent(this.txt_patwariArea, -2, -1, -2).addComponent(this.combo_ownerShare, -2, -1, -2).addComponent(this.combo_share, -2, -1, -2).addComponent(this.jLabel27).addComponent(this.txt_calculatedShare, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel59).addComponent(this.txt_girdawari, -2, -1, -2)).addComponent(this.btn_addProperty)).addGap(6, 6, 6)));
        this.jPanel7.setBackground(new Color(197, 217, 241));
        this.jLabel28.setHorizontalAlignment(0);
        this.jLabel28.setText("Name");
        this.combo_deedNature.setEditable(true);
        this.combo_deedNature.setModel(new DefaultComboBoxModel<String>(new String[] { "Sale Deed", "Lease Deed", "Release Deed" }));
        this.jLabel29.setHorizontalAlignment(0);
        this.jLabel29.setText("Date");
        this.btn_addChain.setText("Add Chain");
        this.btn_addChain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_addChainActionPerformed(evt);
            }
        });
        this.btn_removeLastChain.setText("Remove Last");
        this.btn_removeLastChain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_removeLastChainActionPerformed(evt);
            }
        });
        this.jLabel36.setText("Khasra");
        this.jLabel37.setText("Size");
        this.txt_chain.setEditable(false);
        this.txt_chain.setColumns(20);
        this.txt_chain.setRows(1);
        this.txt_chain.setWrapStyleWord(true);
        this.jScrollPane1.setViewportView(this.txt_chain);
        this.jLabel30.setHorizontalAlignment(0);
        this.jLabel30.setText("<HTML><CENTER>Channel History</CENTER></HTML>");
        final GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel30, -2, 53, -2).addComponent(this.jLabel28, GroupLayout.Alignment.TRAILING, -2, 49, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addComponent(this.btn_addChain, -2, 183, -2).addGap(43, 43, 43).addComponent(this.btn_removeLastChain, -2, 180, -2).addGap(196, 196, 196)).addGroup(jPanel7Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.txt_historyName, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.combo_deedNature, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel36, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_channelKhasra, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel37, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_channelSize, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel29, -2, 33, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_deedExecutionDate, -2, 98, -2))).addGap(18, 18, 18)))));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel28).addComponent(this.txt_historyName, -2, -1, -2).addComponent(this.combo_deedNature, -2, -1, -2).addComponent(this.jLabel29).addComponent(this.txt_deedExecutionDate, -2, -1, -2).addComponent(this.jLabel36).addComponent(this.txt_channelKhasra, -2, -1, -2).addComponent(this.jLabel37).addComponent(this.txt_channelSize, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btn_addChain).addComponent(this.btn_removeLastChain)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel30, -1, 40, 32767).addComponent(this.jScrollPane1)).addGap(6, 6, 6)));
        this.jLabel35.setBackground(new Color(197, 217, 241));
        this.jLabel35.setFont(new Font("Tahoma", 1, 11));
        this.jLabel35.setHorizontalAlignment(0);
        this.jLabel35.setText("<HTML><U>Channel History</U></HTML>");
        this.jLabel35.setOpaque(true);
        final GroupLayout panelPropertyAndChainLayout = new GroupLayout(this.panelPropertyAndChain);
        this.panelPropertyAndChain.setLayout(panelPropertyAndChainLayout);
        panelPropertyAndChainLayout.setHorizontalGroup(panelPropertyAndChainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelPropertyAndChainLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(panelPropertyAndChainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel13, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel6, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel35, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, 0, 32767)).addContainerGap()));
        panelPropertyAndChainLayout.setVerticalGroup(panelPropertyAndChainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelPropertyAndChainLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel13, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addGap(7, 7, 7).addComponent(this.jLabel35, -2, -1, -2).addGap(6, 6, 6).addComponent(this.jPanel7, -2, -1, -2).addGap(6, 6, 6)));
        this.panelTable.setBackground(new Color(255, 255, 204));
        this.jPanel13.setBackground(new Color(197, 217, 241));
        this.jScrollPane2.setBackground(new Color(255, 204, 255));
        this.tab_properties.setModel(new DefaultTableModel(new Object[0][], new String[]{"HeldBy", "Village", "Tehsil", "District", "State", "KhasraNo", "Size", "Landtype", "Jamabandi", "TLDate", "KhataNo", "DLC", "Patwari Village", "Patwari Area", "Owner/Share", "Share", "Calculated Share", "Channel History", "Girdawari"}) {
            Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tab_properties.setAutoResizeMode(0);
        this.tab_properties.setFocusable(false);
        this.tab_properties.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                AdvocateHelperUI.this.tab_propertiesMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.tab_properties);
        final GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
        this.jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 808, -2).addContainerGap(-1, 32767)));
        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jScrollPane2, -2, 92, -2).addContainerGap(-1, 32767)));
        final GroupLayout panelTableLayout = new GroupLayout(this.panelTable);
        this.panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(panelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelTableLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel13, -2, -1, -2).addContainerGap(-1, 32767)));
        panelTableLayout.setVerticalGroup(panelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelTableLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel13, -2, -1, -2).addGap(6, 6, 6)));
        this.panelApplicantInfo.setBackground(new Color(255, 255, 204));
        this.jLabel8.setBackground(new Color(197, 217, 241));
        this.jLabel8.setFont(new Font("Tahoma", 1, 11));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("<HTML><U>Applicant Information</U></HTML>");
        this.jLabel8.setOpaque(true);
        this.jPanel16.setBackground(new Color(197, 217, 241));
        this.jLabel12.setHorizontalAlignment(0);
        this.jLabel12.setText("Age");
        this.jLabel12.setVisible(false);
        this.combo_fh.setModel(new DefaultComboBoxModel<String>(new String[] { "S/o", "D/o", "W/o", "Adopted S/o", "Adopted D/o" }));
        this.combo_fh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.combo_fhActionPerformed(evt);
            }
        });
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("Cast");
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("Name");
        this.jLabel33.setText("Address");
        final GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().
                                addComponent(this.jLabel9, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.txt_name, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.combo_fh, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.txt_fhName, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.jLabel11, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.txt_cast, -2, 71, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.jLabel33, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.txt_address, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.jLabel12, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.txt_age, -2, 61, -2).addContainerGap(-1, 32767)));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.txt_name, -2, -1, -2).addComponent(this.combo_fh, -2, -1, -2).addComponent(this.txt_fhName, -2, -1, -2).addComponent(this.jLabel11).addComponent(this.txt_cast, -2, -1, -2).addComponent(this.jLabel12).addComponent(this.txt_age, -2, -1, -2).addComponent(this.jLabel33).addComponent(this.txt_address, -2, -1, -2)).addContainerGap()));
        final GroupLayout panelApplicantInfoLayout = new GroupLayout(this.panelApplicantInfo);
        this.panelApplicantInfo.setLayout(panelApplicantInfoLayout);
        panelApplicantInfoLayout.setHorizontalGroup(panelApplicantInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelApplicantInfoLayout.createSequentialGroup().addContainerGap().addGroup(panelApplicantInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel16, -2, -1, -2).addComponent(this.jLabel8, -2, 828, -2)).addContainerGap()));
        panelApplicantInfoLayout.setVerticalGroup(panelApplicantInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelApplicantInfoLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel16, -2, -1, -2).addGap(6, 6, 6)));
        this.list_documents.setModel(new AbstractListModel<String>() {
            String[] strings = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return this.strings.length;
            }

            public String getElementAt(int i) {
                return this.strings[i];
            }
        });
        this.list_documents.setSelectionMode(0);
        this.list_documents.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                AdvocateHelperUI.this.list_documentsMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.list_documents);
        this.jLabel60.setFont(new Font("Tahoma", 1, 12));
        this.jLabel60.setHorizontalAlignment(0);
        this.jLabel60.setText("Documents List");
        final GroupLayout panelDocumentListLayout = new GroupLayout(this.panelDocumentList);
        this.panelDocumentList.setLayout(panelDocumentListLayout);
        panelDocumentListLayout.setHorizontalGroup(panelDocumentListLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, 310, -2).addComponent(this.jLabel60, -1, -1, 32767));
        panelDocumentListLayout.setVerticalGroup(panelDocumentListLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelDocumentListLayout.createSequentialGroup().addComponent(this.jLabel60, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 249, 32767)));
        this.menu_removeDocumentList.setText("Remove");
        this.menu_removeDocumentList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_removeDocumentListActionPerformed(evt);
            }
        });
        this.popup_documentList.add(this.menu_removeDocumentList);
        this.setDefaultCloseOperation(3);
        this.setTitle("Advocate Helper V1.8 Developed by Khetraj Bhakar, Mob : 9205135665");
        this.setResizable(false);
        this.panelButtons.setBackground(new Color(255, 255, 204));
        this.jPanel14.setBackground(new Color(197, 217, 241));
        this.btn_save.setText("Save");
        this.btn_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_saveActionPerformed(evt);
            }
        });
        this.btn_clear.setText("Clear");
        this.btn_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_clearActionPerformed(evt);
            }
        });
        this.btn_print.setText("Print");
        this.btn_print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.btn_printActionPerformed(evt);
            }
        });
        final GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
        this.jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(331, 331, 331).addComponent(this.btn_save).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btn_clear).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btn_print).addContainerGap(316, 32767)));
        jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btn_save).addComponent(this.btn_clear).addComponent(this.btn_print)).addGap(6, 6, 6)));
        final GroupLayout panelButtonsLayout = new GroupLayout(this.panelButtons);
        this.panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(panelButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelButtonsLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel14, -2, -1, -2).addContainerGap(-1, 32767)));
        panelButtonsLayout.setVerticalGroup(panelButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelButtonsLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel14, -2, -1, -2).addContainerGap(-1, 32767)));
        this.panel_main.setBackground(new Color(255, 255, 204));
        final GroupLayout panel_mainLayout = new GroupLayout(this.panel_main);
        this.panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(panel_mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 848, 32767));
        panel_mainLayout.setVerticalGroup(panel_mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 614, 32767));
        this.jMenu2.setText("Tools");
        this.menu_editSearch.setText("Edit Search");
        this.menu_editSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_editSearchActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.menu_editSearch);
        this.menu_copySearch.setText("Copy Search");
        this.menu_copySearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_copySearchActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.menu_copySearch);
        this.jMenu2.add(this.jSeparator1);
        this.menu_search.setText("Search Reports");
        this.menu_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_searchActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.menu_search);
        this.menu_switchToAabadi.setText("Switch to Aabadi");
        this.menu_switchToAabadi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdvocateHelperUI.this.menu_switchToAabadiActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.menu_switchToAabadi);
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelButtons, -1, -1, 32767).addComponent(this.panel_main, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panel_main, -2, -1, -2).addGap(0, 0, 0).addComponent(this.panelButtons, -2, -1, -2)));
        this.pack();
    }

    private void combo_bankActionPerformed(final ActionEvent evt) {
        this.selectedBank = (String)this.combo_bank.getSelectedItem();
        if (this.lbl_logo.getWidth() > 0) {
            this.setLogo();
        }
    }

    private void combo_branchActionPerformed(final ActionEvent evt) {
        this.selectedBranch = this.combo_branch.getSelectedItem().toString();
    }

    private void combo_searchTypeActionPerformed(final ActionEvent evt) {
        this.selectedSearchType = this.combo_searchType.getSelectedItem().toString();
        final String selectedSearchType = this.selectedSearchType;
        switch (selectedSearchType) {
            case "Mortgaged": {
                this.txt_mortgagedBank.setEnabled(true);
                this.txt_mortgagedBranch.setEnabled(true);
                this.combo_mortgagedWith.setEnabled(true);
                this.alreadyMortgaged = true;
                break;
            }
            default: {
                this.txt_mortgagedBank.setEnabled(false);
                this.txt_mortgagedBank.setText("");
                this.txt_mortgagedBranch.setEnabled(false);
                this.txt_mortgagedBranch.setText("");
                this.combo_mortgagedWith.setEnabled(false);
                this.alreadyMortgaged = false;
                break;
            }
        }
    }

    private void combo_mortgagedWithActionPerformed(final ActionEvent evt) {
        this.selectedMortgagedWith = this.combo_mortgagedWith.getSelectedItem().toString();
    }

    private void combo_fhActionPerformed(final ActionEvent evt) {
        this.selectedFh = this.combo_fh.getSelectedItem().toString();
    }

    private void btn_addChainActionPerformed(final ActionEvent evt) {
        final String historyName = this.txt_historyName.getText().trim();
        final String deed = this.combo_deedNature.getSelectedItem().toString();
        final String deedDate = this.txt_deedExecutionDate.getText().trim();
        final String channelKhasra = this.txt_channelKhasra.getText().trim();
        final String channelSize = this.txt_channelSize.getText().trim();
        JComponent comp = null;
        boolean cancel = false;
        if (historyName.isEmpty()) {
            cancel = true;
            comp = this.txt_historyName;
        }
        if (deedDate.isEmpty()) {
            cancel = true;
            comp = this.txt_deedExecutionDate;
        }
        if (channelKhasra.isEmpty()) {
            cancel = true;
            comp = this.txt_channelKhasra;
        }
        if (channelSize.isEmpty()) {
            cancel = true;
            comp = this.txt_channelSize;
        }
        if (cancel) {
            comp.requestFocus();
            comp.getToolkit().beep();
        }
        final ChannelHistory channelHistory = new ChannelHistory();
        channelHistory.setDeedDate(deedDate);
        channelHistory.setName(historyName);
        channelHistory.setNature(deed);
        channelHistory.setKhasra(channelKhasra);
        channelHistory.setSize(channelSize);
        this.channelHistories.add(channelHistory);
        this.setChainText();
        this.clearChannelHistoryFields();
    }

    private void btn_removeLastChainActionPerformed(final ActionEvent evt) {
        this.channelHistories.remove(this.channelHistories.size() - 1);
        this.setChainText();
        this.getToolkit().beep();
    }

    private void btn_addPropertyActionPerformed(final ActionEvent evt) {
        if (this.txt_calculatedShare.getText().trim().isEmpty()) {
            this.getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Fields empty", "Empty", 0);
            return;
        }
        final Object[] data = new Object[19];
        if (!this.txt_historyName.getText().trim().isEmpty()) {
            this.btn_addChainActionPerformed(evt);
        }
        final String heldBy = this.combo_heldBy.getSelectedItem().toString();
        final String village = this.txt_village.getText().trim();
        final String tehsil = this.txt_tehsil.getText().trim();
        final String district = this.txt_district.getText().trim();
        final String state = this.txt_state.getText().trim();
        final String khasra = this.txt_khasraNo.getText().trim();
        final String khata = this.txt_khataNo.getText().trim();
        final String size = this.txt_size.getText().trim();
        final String landtype = this.combo_landType.getSelectedItem().toString().trim();
        final String jamabandi = this.txt_jamabandi.getText().trim();
        final String girdawari = this.txt_girdawari.getText().trim();
        final String tldate = this.txt_tldate.getText().trim();
        String dlc = this.txt_dlc.getText().trim();
        final String patwariVillage = this.txt_patwariVillage.getText().trim();
        final String patwariArea = this.txt_patwariArea.getText().trim();
        final String ownerShare = this.combo_ownerShare.getSelectedItem().toString().trim();
        String share;
        if (this.combo_share.getSelectedIndex() == -1) {
            share = "";
        }
        else {
            share = this.combo_share.getSelectedItem().toString().trim();
        }
        if (dlc.isEmpty()) {
            dlc = "0";
        }
        final String calculatedShare = this.txt_calculatedShare.getText().trim();
        final String chain = "";
        data[ColumnNames.CALCULATEDSHARE] = calculatedShare;
        data[ColumnNames.CHANNELHISTORY] = chain;
        data[ColumnNames.DISTRICT] = district;
        data[ColumnNames.DLC] = dlc;
        data[ColumnNames.HELDBY] = heldBy;
        data[ColumnNames.JAMABANDI] = jamabandi;
        data[ColumnNames.KHASRANO] = khasra;
        data[ColumnNames.KHATANO] = khata;
        data[ColumnNames.LANDTYPE] = landtype;
        data[ColumnNames.OWNERSHARE] = ownerShare;
        data[ColumnNames.PATWARIAREA] = patwariArea;
        data[ColumnNames.PATWARIVILLAGE] = patwariVillage;
        data[ColumnNames.SHARE] = share;
        data[ColumnNames.SIZE] = size;
        data[ColumnNames.STATE] = state;
        data[ColumnNames.TEHSIL] = tehsil;
        data[ColumnNames.TLDATE] = tldate;
        data[ColumnNames.VILLAGE] = village;
        data[ColumnNames.GIRDAWARI] = girdawari;
        for (int i = 0; i < data.length; ++i) {
            if (data[i] == null) {
                data[i] = "";
            }
        }
        this.model.addRow(data);
        this.enableChain();
        this.clearPropertyFields();
        this.getToolkit().beep();
    }

    private void btn_saveActionPerformed(final ActionEvent evt) {
        if (this.menu_switchToAabadi.isSelected()) {
            this.aabadiSearchSaveProcess();
        }
        else {
            this.normalSearchSaveProcess();
        }
    }

    private void combo_advocateActionPerformed(final ActionEvent evt) {
        this.selectedAdvocate = this.combo_advocate.getSelectedItem().toString();
    }

    private void combo_ownerShareActionPerformed(final ActionEvent evt) {
        if (this.combo_ownerShare.getSelectedIndex() == 0) {
            this.combo_share.setEnabled(false);
            this.combo_share.setSelectedItem("");
            this.txt_calculatedShare.setText("");
        }
        else {
            this.combo_share.setEnabled(true);
        }
    }

    private void combo_ownerShareFocusLost(final FocusEvent evt) {
        if (this.combo_ownerShare.getSelectedIndex() == 0) {
            this.calculateShare();
        }
    }

    private void combo_heldByActionPerformed(final ActionEvent evt) {
    }

    private void txt_sizeFocusLost(final FocusEvent evt) {
        final String size = this.txt_size.getText().trim();
        if (size.isEmpty()) {
            return;
        }
        final Matcher r = this.ptSize.matcher(size);
        if (!r.matches()) {
            this.txt_size.getToolkit().beep();
            this.txt_size.requestFocus();
            return;
        }
        this.calculateShare();
    }

    private void txt_searchPeriodFocusLost(final FocusEvent evt) {
        this.calculatePeriod();
    }

    private void menu_editSearchActionPerformed(final ActionEvent evt) {
        final String sno = JOptionPane.showInputDialog("Enter search number to edit");
        this.fetchSearch(sno);
    }

    private void btn_printActionPerformed(final ActionEvent evt) {
        if (this.menu_switchToAabadi.isSelected()) {
            if (!this.isFilledAabadi()) {
                return;
            }
        }
        else if (!this.isFilledNormal()) {
            return;
        }
        try {
            this.setCursor(this.wait);
            this.prepareReports();
            JOptionPane.showMessageDialog(this, "Report Created !!!", "Created", 1);
        }
        catch (Exception e) {
            System.out.println("Error in creating report because of " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in creating report because of " + e.getMessage(), "Error", 0);
        }
        final Desktop desk = Desktop.getDesktop();
        try {
            desk.print(new File(this.lastFile));
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        this.setCursor(this.def);
    }

    private void txt_villageFocusLost(final FocusEvent evt) {
        this.txt_patwariVillage.setText(this.txt_village.getText());
    }

    private void btn_clearActionPerformed(final ActionEvent evt) {
        this.clearAll();
    }

    private void menu_copySearchActionPerformed(final ActionEvent evt) {
        final String sno = JOptionPane.showInputDialog("Enter search number to create a Copy");
        this.fetchSearch(sno);
        final Integer maxNo = this.dbHandler.fetchMaxNumber();
        System.out.println("" + maxNo);
        this.txt_sno.setText("" + (maxNo + 1));
    }

    private void tab_propertiesMouseClicked(final MouseEvent evt) {
        if (evt.getButton() == 3 && this.tab_properties.getSelectedRow() != -1) {
            this.popup.show(this.tab_properties, evt.getX(), evt.getY());
        }
    }

    private void menu_removeActionPerformed(final ActionEvent evt) {
        final int ind = this.tab_properties.getSelectedRow();
        if (ind != -1) {
            this.model.removeRow(this.tab_properties.convertRowIndexToModel(ind));
        }
    }

    private void menu_searchActionPerformed(final ActionEvent evt) {
        this.dialog = new JDialog(this, "Search Report");
        final PanelReport report = new PanelReport();
        this.dialog.setContentPane((Container)report);
        this.dialog.pack();
        this.dialog.setLocationRelativeTo(this);
        this.dialog.setVisible(true);
    }

    private void menu_switchToAabadiActionPerformed(final ActionEvent evt) {
        if (this.menu_switchToAabadi.isSelected()) {
            this.showAabadi();
        }
        else {
            this.showNormal();
        }
    }

    private void btn_viewListDocumentAabadiActionPerformed(final ActionEvent evt) {
        (this.dialog = new JDialog(this, "Documents List")).setContentPane(this.panelDocumentList);
        this.dialog.pack();
        this.dialog.setLocationRelativeTo(this);
        this.dialog.setVisible(true);
    }

    private void btn_addDocumentAabadiActionPerformed(final ActionEvent evt) {
        final String documentType = this.combo_documentType.getSelectedItem().toString();
        final String issuedTo = this.txt_issuedToAabadi.getText().trim();
        final String date = this.txt_issuedDateAabadi.getText().trim();
        final String issuedBy = this.txt_issuedByAabadi.getText().trim();
        final String samwat = this.txt_samwatAabadi.getText().trim();
        final String documentNumber = this.txt_documentNoAabadi.getText().trim();
        final String registeredDate = this.txt_registerDate.getText().trim();
        final String required = this.combo_requiredAabadi.getSelectedItem().toString();
        boolean cancel = false;
        JComponent comp = null;
        String err = "";
        if (issuedBy.isEmpty()) {
            cancel = true;
            comp = this.txt_issuedByAabadi;
            err = "Issued By Empty";
        }
        else if (issuedTo.isEmpty()) {
            cancel = true;
            comp = this.txt_issuedToAabadi;
            err = "Issued To Empty";
        }
        else if (date.isEmpty()) {
            cancel = true;
            comp = this.txt_issuedDateAabadi;
            err = "Issued Date Empty";
        }
        else if (registeredDate.isEmpty()) {
            cancel = true;
            comp = this.txt_registerDate;
            err = "Registered Date Empty";
        }
        if (cancel) {
            JOptionPane.showMessageDialog(this, err, "Error", 0);
            comp.requestFocus();
            return;
        }
        final DocumentList documentList = new DocumentList();
        documentList.setDate(date);
        documentList.setDocumentName(documentType);
        documentList.setDocumentNumber(documentNumber);
        documentList.setIssuedBy(issuedBy);
        documentList.setIssuedByCaption((String)this.combo_issuedBy.getSelectedItem());
        documentList.setIssuedTo(issuedTo);
        documentList.setIssuedToCaption((String)this.combo_issuedTo.getSelectedItem());
        documentList.setRequired(required);
        documentList.setSamwat(samwat);
        documentList.setRegisteredDate(registeredDate);
        this.documentLists.add(documentList);
        final String str = documentType + " " + documentList.getIssuedByCaption() + " " + issuedBy + " " + documentList.getIssuedToCaption() + " " + issuedTo + " Date " + date + " Document number " + documentNumber + " Samwat " + samwat + " required ? - " + required;
        this.modelDocumentList.addElement(str);
        this.setChainTextAabadi();
        this.clearDocumentListFields();
    }

    private void menu_removeDocumentListActionPerformed(final ActionEvent evt) {
        final int ind = this.list_documents.getSelectedIndex();
        if (ind != -1) {
            this.modelDocumentList.remove(ind);
            this.documentLists.remove(ind);
            this.setChainTextAabadi();
        }
    }

    private void list_documentsMouseClicked(final MouseEvent evt) {
        if (evt.getButton() == 3) {
            this.popup_documentList.show(this.list_documents, evt.getX(), evt.getY());
        }
    }

    private void menu_editActionPerformed(final ActionEvent evt) {
        final int ind = this.tab_properties.getSelectedRow();
        if (ind != -1) {
            String str;
            this.txt_calculatedShare.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.CALCULATEDSHARE)) == null) ? "" : str);
            this.txt_district.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.DISTRICT)) == null) ? "" : str);
            this.txt_dlc.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.DLC)) == null) ? "" : str);
            this.txt_girdawari.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.GIRDAWARI)) == null) ? "" : str);
            this.combo_heldBy.setSelectedItem(((str = (String)this.model.getValueAt(ind, ColumnNames.HELDBY)) == null) ? "" : str);
            this.txt_jamabandi.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.JAMABANDI)) == null) ? "" : str);
            this.txt_khasraNo.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.KHASRANO)) == null) ? "" : str);
            this.txt_khataNo.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.KHATANO)) == null) ? "" : str);
            this.combo_landType.setSelectedItem(((str = (String)this.model.getValueAt(ind, ColumnNames.LANDTYPE)) == null) ? "" : str);
            this.combo_ownerShare.setSelectedItem(((str = (String)this.model.getValueAt(ind, ColumnNames.OWNERSHARE)) == null) ? "" : str);
            this.txt_patwariArea.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.PATWARIAREA)) == null) ? "" : str);
            this.txt_patwariVillage.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.PATWARIVILLAGE)) == null) ? "" : str);
            this.combo_share.setSelectedItem(((str = (String)this.model.getValueAt(ind, ColumnNames.SHARE)) == null) ? "" : str);
            this.txt_size.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.SIZE)) == null) ? "" : str);
            this.txt_state.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.STATE)) == null) ? "" : str);
            this.txt_tehsil.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.TEHSIL)) == null) ? "" : str);
            this.txt_tldate.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.TLDATE)) == null) ? "" : str);
            this.txt_village.setText(((str = (String)this.model.getValueAt(ind, ColumnNames.VILLAGE)) == null) ? "" : str);
            this.model.removeRow(this.tab_properties.convertRowIndexToModel(ind));
            this.combo_heldBy.requestFocus();
            this.getToolkit().beep();
        }
    }

    private void txt_jamabandiFocusGained(final FocusEvent evt) {
        this.txt_jamabandi.setCaretPosition(0);
    }

    private void txt_girdawariFocusGained(final FocusEvent evt) {
        this.txt_girdawari.setCaretPosition(0);
    }

    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            Logger.getLogger(AdvocateHelperUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new AdvocateHelperUI()).setVisible(true);
            }
        });
    }

    private void checkValidUser() {
        if (!this.dbHandler.isValidLogin()) {
            JOptionPane.showMessageDialog(null, "Invalid login found, Contact Khetraj, Mobile 9205135665", "Invalid Login", 0);
            System.exit(0);
        }
    }

    boolean isFilledNormal() {
        if (!this.txt_calculatedShare.getText().trim().isEmpty()) {
            this.btn_addPropertyActionPerformed(null);
        }
        if (this.txt_historyName.isEnabled() && this.channelHistories.size() == 0) {
            this.getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Channel History and than save", "Error", 0);
            return false;
        }
        if (this.selectedBank.equalsIgnoreCase("select bank")) {
            this.getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Select bank and than save", "Error", 0);
            return false;
        }
        if (this.model.getRowCount() == 0) {
            this.getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please add property information and than save", "Error", 0);
            return false;
        }
        return true;
    }

    boolean isFilledAabadi() {
        boolean filled = true;
        String err = "";
        JComponent comp = null;
        final String name = this.txt_name.getText().trim();
        final String fhname = this.txt_fhName.getText().trim();
        final String cast = this.txt_cast.getText().trim();
        final String address = this.txt_address.getText().trim();
        final String date = this.txt_date.getText().trim();
        final String bank = this.combo_bank.getSelectedItem().toString();
        final String branch = this.combo_branch.getSelectedItem().toString();
        final String subregistrar = this.txt_subRegistrar.getText().trim();
        final String searchPeriod = this.txt_searchPeriod.getText().trim();
        final String village = this.txt_villageAabadi.getText().trim();
        final String district = this.txt_districtAabadi.getText().trim();
        final String state = this.txt_stateAabadi.getText().trim();
        final String tehsil = this.txt_tehsilAabadi.getText().trim();
        final String khasra = this.txt_khasraNoAabadi.getText().trim();
        final String patta = this.txt_pattaNo.getText().trim();
        final String size = this.txt_sizeAabadi.getText().trim();
        final String east = this.txt_east.getText().trim();
        final String west = this.txt_west.getText().trim();
        final String north = this.txt_north.getText().trim();
        final String south = this.txt_south.getText().trim();
        final String dlc = this.txt_dlcAabadi.getText().trim();
        if (name.isEmpty()) {
            filled = false;
            comp = this.txt_name;
            err = "Name empty";
        }
        else if (fhname.isEmpty()) {
            filled = false;
            comp = this.txt_fhName;
            err = "Father/husband empty";
        }
        else if (cast.isEmpty()) {
            filled = false;
            comp = this.txt_cast;
            err = "cast empty";
        }
        else if (address.isEmpty()) {
            filled = false;
            comp = this.txt_address;
            err = "address empty";
        }
        else if (date.isEmpty()) {
            filled = false;
            comp = this.txt_date;
            err = "date empty";
        }
        else if (bank.isEmpty()) {
            filled = false;
            comp = this.combo_bank;
            err = "bank empty";
        }
        else if (branch.isEmpty()) {
            filled = false;
            comp = this.combo_branch;
            err = "branch empty";
        }
        else if (subregistrar.isEmpty()) {
            filled = false;
            comp = this.txt_subRegistrar;
            err = "sub-registrar empty";
        }
        else if (searchPeriod.isEmpty()) {
            filled = false;
            comp = this.txt_searchPeriod;
            err = "Search Period empty";
        }
        else if (village.isEmpty()) {
            filled = false;
            comp = this.txt_villageAabadi;
            err = "village empty";
        }
        else if (district.isEmpty()) {
            filled = false;
            comp = this.txt_districtAabadi;
            err = "District empty";
        }
        else if (state.isEmpty()) {
            filled = false;
            comp = this.txt_stateAabadi;
            err = "State empty";
        }
        else if (tehsil.isEmpty()) {
            filled = false;
            comp = this.txt_tehsilAabadi;
            err = "tehsil empty";
        }
        else if (khasra.isEmpty() && patta.isEmpty()) {
            filled = false;
            comp = this.txt_pattaNo;
            err = "Khasra number and patta both empty";
        }
        else if (size.isEmpty()) {
            filled = false;
            comp = this.txt_sizeAabadi;
            err = "Measurement(Size) empty";
        }
        else if (east.isEmpty()) {
            filled = false;
            comp = this.txt_east;
            err = "East empty";
        }
        else if (west.isEmpty()) {
            filled = false;
            comp = this.txt_west;
            err = "west empty";
        }
        else if (north.isEmpty()) {
            filled = false;
            comp = this.txt_north;
            err = "north empty";
        }
        else if (south.isEmpty()) {
            filled = false;
            comp = this.txt_south;
            err = "south empty";
        }
        else if (dlc.isEmpty()) {
            filled = false;
            comp = this.txt_dlcAabadi;
            err = "DLC empty";
        }
        else if (!this.txt_issuedToAabadi.getText().trim().isEmpty()) {
            this.btn_addDocumentAabadiActionPerformed(null);
            filled = (this.modelDocumentList.getSize() > 0);
            if (!filled) {
                err = "Add at least one document list";
                comp = this.combo_documentType;
            }
        }
        else if (this.modelDocumentList.getSize() == 0) {
            err = "Add at least one document list";
            filled = false;
            comp = this.combo_documentType;
        }
        if (!filled) {
            JOptionPane.showMessageDialog(this, err, "Error", 0);
            comp.requestFocus();
            this.getToolkit().beep();
        }
        return filled;
    }

    private void normalSearchSaveProcess() {
        if (!this.isFilledNormal()) {
            return;
        }
        this.properties.clear();
        for (int i = 0; i < this.model.getRowCount(); ++i) {
            final Property property = new Property();
            property.setShareCalculated(new Double(this.model.getValueAt(i, ColumnNames.CALCULATEDSHARE).toString()));
            property.setChain(this.model.getValueAt(i, ColumnNames.CHANNELHISTORY).toString());
            property.setDistrict(this.model.getValueAt(i, ColumnNames.DISTRICT).toString());
            property.setDlc(new Double(this.model.getValueAt(i, ColumnNames.DLC).toString()));
            property.setHeldBy(this.model.getValueAt(i, ColumnNames.HELDBY).toString());
            property.setJamabandi(this.model.getValueAt(i, ColumnNames.JAMABANDI).toString());
            property.setGirdawari(this.model.getValueAt(i, ColumnNames.GIRDAWARI).toString());
            property.setKhasraNo(this.model.getValueAt(i, ColumnNames.KHASRANO).toString());
            property.setKhataNo(this.model.getValueAt(i, ColumnNames.KHATANO).toString());
            property.setLandType(this.model.getValueAt(i, ColumnNames.LANDTYPE).toString());
            property.setOwner(this.model.getValueAt(i, ColumnNames.OWNERSHARE).toString());
            property.setPatwariArea(this.model.getValueAt(i, ColumnNames.PATWARIAREA).toString());
            property.setPatwariVillage(this.model.getValueAt(i, ColumnNames.PATWARIVILLAGE).toString());
            property.setShare(this.model.getValueAt(i, ColumnNames.SHARE).toString());
            property.setSize(this.model.getValueAt(i, ColumnNames.SIZE).toString());
            property.setState(this.model.getValueAt(i, ColumnNames.STATE).toString());
            property.setTehsil(this.model.getValueAt(i, ColumnNames.TEHSIL).toString());
            property.setTldate(this.model.getValueAt(i, ColumnNames.TLDATE).toString());
            property.setVillage(this.model.getValueAt(i, ColumnNames.VILLAGE).toString());
            property.setSno(Integer.valueOf(Integer.parseInt(this.txt_sno.getText().trim())));
            property.setPsno(Integer.valueOf(i));
            this.properties.add(property);
        }
        (this.applicantInfo = new ApplicantInfo()).setAddress(this.txt_address.getText().trim());
        this.applicantInfo.setAge(this.txt_age.getText().trim());
        this.applicantInfo.setFh(this.selectedFh);
        this.applicantInfo.setFhName(this.txt_fhName.getText().trim());
        this.applicantInfo.setName(this.txt_name.getText().trim());
        this.applicantInfo.setSirName(this.txt_cast.getText().trim());
        this.applicantInfo.setProperties((ArrayList)this.properties);
        this.applicantInfo.setSno(Integer.parseInt(this.txt_sno.getText().trim()));
        (this.searchMaster = new SearchMaster()).setAdvocate(this.selectedAdvocate);
        this.searchMaster.setApplicantInfo(this.applicantInfo);
        this.searchMaster.setBank(this.selectedBank);
        this.searchMaster.setBranch(this.selectedBranch);
        this.searchMaster.setDateOfSearch(this.txt_date.getText().trim());
        this.searchMaster.setFlag("");
        this.searchMaster.setMortgagedBank(this.txt_mortgagedBank.getText().trim());
        this.searchMaster.setMortgagedBranch(this.txt_mortgagedBranch.getText().trim());
        this.searchMaster.setMortgagedWith(this.selectedMortgagedWith);
        this.searchMaster.setRefNo(this.txt_refNo.getText().trim());
        this.searchMaster.setRemark("");
        this.searchMaster.setSearchPeriod(this.txt_searchPeriod.getText().trim());
        this.searchMaster.setSearchType(this.selectedSearchType);
        this.searchMaster.setSubRegistrar(this.txt_subRegistrar.getText().trim());
        this.searchMaster.setSearchCategory("NORMAL");
        this.searchMaster.setSno(Integer.valueOf(Integer.parseInt(this.txt_sno.getText().trim())));
        try {
            this.setCursor(this.wait);
            this.storeData();
            this.prepareReports();
            JOptionPane.showMessageDialog(this, "Report Created !!!", "Created", 1);
        }
        catch (Exception e) {
            System.out.println("Error in creating report because of " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in creating report because of " + e.getMessage(), "Error", 0);
        }
        this.clearAll();
        this.setCursor(this.def);
    }

    private void aabadiSearchSaveProcess() {
        if (!this.isFilledAabadi()) {
            return;
        }
        this.properties.clear();
        (this.aabadiProperty = new AabadiProperty()).setBookNo(this.txt_bookNo.getText().trim());
        this.aabadiProperty.setDistrict(this.txt_districtAabadi.getText().trim());
        this.aabadiProperty.setDlc(this.txt_dlcAabadi.getText().trim());
        this.aabadiProperty.setEast(this.txt_east.getText().trim());
        this.aabadiProperty.setKhasraNo(this.txt_khasraNoAabadi.getText().trim());
        this.aabadiProperty.setMissalNo(this.txt_missalNo.getText().trim());
        this.aabadiProperty.setNorth(this.txt_north.getText().trim());
        this.aabadiProperty.setPattaNo(this.txt_pattaNo.getText().trim());
        this.aabadiProperty.setReceiptNumber(this.txt_receiptNumberAabadi.getText().trim());
        this.aabadiProperty.setSize(this.txt_sizeAabadi.getText().trim());
        this.aabadiProperty.setSouth(this.txt_south.getText().trim());
        this.aabadiProperty.setState(this.txt_stateAabadi.getText().trim());
        this.aabadiProperty.setTehsil(this.txt_tehsilAabadi.getText().trim());
        this.aabadiProperty.setVillage(this.txt_villageAabadi.getText().trim());
        this.aabadiProperty.setWest(this.txt_west.getText().trim());
        (this.applicantInfo = new ApplicantInfo()).setAddress(this.txt_address.getText().trim());
        this.applicantInfo.setAge(this.txt_age.getText().trim());
        this.applicantInfo.setFh(this.selectedFh);
        this.applicantInfo.setFhName(this.txt_fhName.getText().trim());
        this.applicantInfo.setName(this.txt_name.getText().trim());
        this.applicantInfo.setSirName(this.txt_cast.getText().trim());
        this.applicantInfo.setProperties((ArrayList)this.properties);
        this.applicantInfo.setAabadiProperty(this.aabadiProperty);
        this.applicantInfo.setDocumentLists((ArrayList)this.documentLists);
        this.applicantInfo.setSno(Integer.parseInt(this.txt_sno.getText().trim()));
        (this.searchMaster = new SearchMaster()).setAdvocate(this.selectedAdvocate);
        this.searchMaster.setSearchCategory("AABADI");
        this.searchMaster.setApplicantInfo(this.applicantInfo);
        this.searchMaster.setBank(this.selectedBank);
        this.searchMaster.setBranch(this.selectedBranch);
        this.searchMaster.setDateOfSearch(this.txt_date.getText().trim());
        this.searchMaster.setFlag("");
        this.searchMaster.setMortgagedBank(this.txt_mortgagedBank.getText().trim());
        this.searchMaster.setMortgagedBranch(this.txt_mortgagedBranch.getText().trim());
        this.searchMaster.setMortgagedWith(this.selectedMortgagedWith);
        this.searchMaster.setRefNo(this.txt_refNo.getText().trim());
        this.searchMaster.setRemark("");
        this.searchMaster.setSearchPeriod(this.txt_searchPeriod.getText().trim());
        this.searchMaster.setSearchType(this.selectedSearchType);
        this.searchMaster.setSubRegistrar(this.txt_subRegistrar.getText().trim());
        this.searchMaster.setSno(Integer.valueOf(Integer.parseInt(this.txt_sno.getText().trim())));
        try {
            this.setCursor(this.wait);
            this.storeData();
            this.prepareReports();
            JOptionPane.showMessageDialog(this, "Report Created !!!", "Created", 1);
        }
        catch (Exception e) {
            System.out.println("Error in creating report because of " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in creating report because of " + e.getMessage(), "Error", 0);
        }
        this.clearAll();
        this.setCursor(this.def);
    }

    private void showAabadi() {
        this.panel_main.removeAll();
        this.panel_main.setLayout((LayoutManager)new MigLayout("", "0[]0", "0[]0[]0"));
        this.panel_main.add(this.panelSearchInfo, "wrap");
        this.panel_main.add(this.panelApplicantInfo, "wrap");
        this.panel_main.add(this.panelAabadi, "wrap");
        this.combo_bank.removeAllItems();
        this.combo_bank.addItem("Select Bank");
        this.combo_bank.addItem("BOB");
        this.combo_bank.addItem("ICICI");
        this.combo_bank.addItem("OBC");
        this.combo_bank.addItem("PNB");
        this.combo_bank.addItem("SBI");
        this.combo_bank.addItem("UCO");
        this.combo_bank.addItem("YES");
        this.pack();
        this.repaint();
        this.revalidate();
    }

    private void showNormal() {
        this.panel_main.removeAll();
        this.panel_main.setLayout((LayoutManager)new MigLayout("", "0[]0", "0[]0[]0"));
        this.panel_main.add(this.panelSearchInfo, "wrap");
        this.panel_main.add(this.panelApplicantInfo, "wrap");
        this.panel_main.add(this.panelPropertyAndChain, "wrap");
        this.panel_main.add(this.panelTable, "wrap");
        this.combo_bank.removeAllItems();
        this.combo_bank.addItem("Select Bank");
        this.combo_bank.addItem("AXIS");
        this.combo_bank.addItem("BOB");
        this.combo_bank.addItem("ICICI");
        this.combo_bank.addItem("OBC");
        this.combo_bank.addItem("PNB");
        this.combo_bank.addItem("SBI");
        this.combo_bank.addItem("RMGB");
        this.combo_bank.addItem("UCO");
        this.combo_bank.addItem("UNION");
        this.combo_bank.addItem("YES");
        this.pack();
        this.repaint();
        this.revalidate();
    }

    void fetchSearch(final String sno) {
        try {
            final int s = Integer.parseInt(sno);
            final ArrayList<SearchMaster> sm = (ArrayList<SearchMaster>)this.dbHandler.fetchSearchMasterRecords(sno);
            if (sm.size() == 0) {
                throw new Exception("Invalid search number");
            }
            this.searchMaster = sm.get(0);
            this.combo_advocate.setSelectedItem(this.searchMaster.getAdvocate());
            this.combo_branch.setSelectedItem(this.searchMaster.getBranch());
            this.txt_date.setText(this.searchMaster.getDateOfSearch());
            this.txt_mortgagedBank.setText(this.searchMaster.getMortgagedBank());
            this.txt_mortgagedBranch.setText(this.searchMaster.getMortgagedBranch());
            this.combo_mortgagedWith.setSelectedItem(this.searchMaster.getMortgagedWith());
            this.txt_refNo.setText(this.searchMaster.getRefNo());
            this.txt_searchPeriod.setText(this.searchMaster.getSearchPeriod());
            this.combo_searchType.setSelectedItem(this.searchMaster.getSearchType());
            this.txt_subRegistrar.setText(this.searchMaster.getSubRegistrar());
            this.txt_sno.setText("" + this.searchMaster.getSno());
            this.applicantInfo = this.searchMaster.getApplicantInfo();
            this.txt_address.setText(this.applicantInfo.getAddress());
            this.txt_age.setText(this.applicantInfo.getAge());
            this.combo_fh.setSelectedItem(this.applicantInfo.getFh());
            this.txt_fhName.setText(this.applicantInfo.getFhName());
            this.txt_name.setText(this.applicantInfo.getName());
            this.txt_cast.setText(this.applicantInfo.getSirName());
            if (this.searchMaster.getSearchCategory().equals("NORMAL")) {
                this.properties = (ArrayList<Property>)this.applicantInfo.getProperties();
                this.channelHistories = (ArrayList<ChannelHistory>)this.applicantInfo.getChannelHistories();
                this.setChainText();
                this.model.setRowCount(0);
                for (final Property property : this.properties) {
                    final Object[] data = new Object[19];
                    data[ColumnNames.CALCULATEDSHARE] = property.getShareCalculated();
                    data[ColumnNames.CHANNELHISTORY] = property.getChain();
                    data[ColumnNames.DISTRICT] = property.getDistrict();
                    data[ColumnNames.DLC] = property.getDlc();
                    data[ColumnNames.HELDBY] = property.getHeldBy();
                    data[ColumnNames.JAMABANDI] = property.getJamabandi();
                    data[ColumnNames.KHASRANO] = property.getKhasraNo();
                    data[ColumnNames.KHATANO] = property.getKhataNo();
                    data[ColumnNames.LANDTYPE] = property.getLandType();
                    data[ColumnNames.OWNERSHARE] = property.getOwner();
                    data[ColumnNames.PATWARIAREA] = property.getPatwariArea();
                    data[ColumnNames.PATWARIVILLAGE] = property.getPatwariVillage();
                    data[ColumnNames.SHARE] = property.getShare();
                    data[ColumnNames.SIZE] = property.getSize();
                    data[ColumnNames.STATE] = property.getState();
                    data[ColumnNames.TEHSIL] = property.getTehsil();
                    data[ColumnNames.TLDATE] = property.getTldate();
                    data[ColumnNames.VILLAGE] = property.getVillage();
                    data[ColumnNames.GIRDAWARI] = property.getGirdawari();
                    for (int i = 0; i < data.length; ++i) {
                        if (data[i] == null) {
                            data[i] = "";
                        }
                        if (data[i] instanceof Number) {
                            data[i] = "" + data[i];
                        }
                    }
                    this.model.addRow(data);
                }
                this.enableChain();
                this.menu_switchToAabadi.setSelected(false);
                this.showNormal();
            }
            else {
                this.aabadiProperty = this.applicantInfo.getAabadiProperty();
                this.txt_bookNo.setText(this.aabadiProperty.getBookNo());
                this.txt_districtAabadi.setText(this.aabadiProperty.getDistrict());
                this.txt_dlcAabadi.setText(this.aabadiProperty.getDlc());
                this.txt_east.setText(this.aabadiProperty.getEast());
                this.txt_khasraNoAabadi.setText(this.aabadiProperty.getKhasraNo());
                this.txt_missalNo.setText(this.aabadiProperty.getMissalNo());
                this.txt_north.setText(this.aabadiProperty.getNorth());
                this.txt_pattaNo.setText(this.aabadiProperty.getPattaNo());
                this.txt_receiptNumberAabadi.setText(this.aabadiProperty.getReceiptNumber());
                this.txt_sizeAabadi.setText(this.aabadiProperty.getSize());
                this.txt_south.setText(this.aabadiProperty.getSouth());
                this.txt_stateAabadi.setText(this.aabadiProperty.getState());
                this.txt_tehsilAabadi.setText(this.aabadiProperty.getTehsil());
                this.txt_villageAabadi.setText(this.aabadiProperty.getVillage());
                this.txt_west.setText(this.aabadiProperty.getWest());
                this.documentLists = (ArrayList<DocumentList>)this.applicantInfo.getDocumentLists();
                this.modelDocumentList.clear();
                for (final DocumentList dList : this.documentLists) {
                    final String str = dList.getDocumentName() + " " + dList.getIssuedByCaption() + " " + dList.getIssuedBy() + " " + dList.getIssuedToCaption() + " " + dList.getIssuedTo() + " Date " + dList.getDate() + " Document number " + dList.getDocumentNumber() + " Samwat " + dList.getSamwat() + " required ? - " + dList.getRequired();
                    this.modelDocumentList.addElement(str);
                }
                this.setChainTextAabadi();
                this.menu_switchToAabadi.setSelected(true);
                this.showAabadi();
            }
            this.combo_bank.setSelectedItem(this.searchMaster.getBank());
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid search number", "Error", 0);
        }
    }

    void createOutputFolders() {
        final String[] folders = { "AXIS", "BOB", "ICICI", "OBC", "PNB", "SBI", "RMGB", "UCO", "UNION","YES" };
        File f = new File("Output");
        if (!f.exists()) {
            f.mkdir();
        }
        for (final String folder : folders) {
            f = new File("Output/" + folder);
            if (!f.exists()) {
                f.mkdir();
            }
        }
    }

    void clearAll() {
        final Integer maxNo = this.dbHandler.fetchMaxNumber();
        System.out.println("" + maxNo);
        this.txt_sno.setText("" + (maxNo + 1));
        this.txt_date.setCaretPosition(0);
        final Date date = new Date();
        final String dt = this.sdf.format(date);
        this.txt_date.setText(dt);
        final Calendar cal = Calendar.getInstance();
        System.out.println("Year " + cal.get(1));
        this.txt_searchPeriod.setText(cal.get(1) - 12 + "-" + cal.get(1));
        this.combo_searchType.setSelectedIndex(0);
        this.txt_mortgagedBank.setText("");
        this.txt_mortgagedBranch.setText("");
        this.txt_subRegistrar.setText("");
        this.txt_name.setText("");
        this.txt_fhName.setText("");
        this.txt_cast.setText("");
        this.txt_address.setText("");
        this.txt_age.setText("");
        this.model.setRowCount(0);
        this.properties.clear();
        this.channelHistories.clear();
        this.applicantInfo = new ApplicantInfo();
        this.searchMaster = new SearchMaster();
        this.txt_village.setText("");
        this.txt_patwariVillage.setText("");
        this.txt_tehsil.setText("");
        this.clearProperty();
        this.clearChannelHistoryFields();
        this.channelHistories.clear();
        this.clearAabadiProperty();
        this.clearDocumentListFields();
        this.documentLists.clear();
        this.modelDocumentList.clear();
        this.txt_chainAabadi.setText("");
        this.lastFile = "";
    }

    void clearProperty() {
        this.txt_khasraNo.setText("");
        this.txt_size.setText("");
        this.txt_jamabandi.setValue(null);
        this.txt_girdawari.setValue(null);
        this.txt_tldate.setValue(null);
        this.txt_khataNo.setText("");
        this.txt_dlc.setText("");
        this.txt_patwariArea.setText("");
        this.txt_calculatedShare.setText("");
        this.txt_chain.setText("");
    }

    void clearAabadiProperty() {
        this.txt_villageAabadi.setText("");
        this.txt_tehsilAabadi.setText("");
        this.txt_khasraNoAabadi.setText("");
        this.txt_pattaNo.setText("");
        this.txt_missalNo.setText("");
        this.txt_bookNo.setText("");
        this.txt_sizeAabadi.setText("");
        this.txt_east.setText("");
        this.txt_west.setText("");
        this.txt_north.setText("");
        this.txt_south.setText("");
    }

    void clearDocumentListFields() {
        this.txt_issuedByAabadi.setText("");
        this.txt_issuedToAabadi.setText("");
        this.txt_issuedDateAabadi.setText("");
        this.txt_documentNoAabadi.setText("");
        this.txt_samwatAabadi.setText("");
        this.combo_requiredAabadi.setSelectedIndex(0);
        this.combo_documentType.requestFocus();
        this.getToolkit().beep();
    }

    void enableChain() {
        boolean ed = false;
        for (int i = 0; i < this.model.getRowCount(); ++i) {
            if (this.model.getValueAt(i, 0).toString().equals("Self-Acquired") || this.model.getValueAt(i, 0).toString().equals("Self-Aquired")) {
                ed = true;
                break;
            }
        }
        this.txt_historyName.setEnabled(ed);
        this.txt_channelKhasra.setEnabled(ed);
        this.txt_channelSize.setEnabled(ed);
        this.combo_deedNature.setEnabled(ed);
        this.txt_deedExecutionDate.setEnabled(ed);
        this.btn_addChain.setEnabled(ed);
        this.btn_removeLastChain.setEnabled(ed);
        this.txt_chain.setEnabled(ed);
    }

    void enablePatwari(final boolean ed) {
        this.txt_patwariArea.setEnabled(ed);
        this.txt_patwariVillage.setEnabled(ed);
    }

    void enableBasic(final boolean ed) {
        this.txt_village.setEnabled(ed);
        this.txt_tehsil.setEnabled(ed);
        this.txt_district.setEnabled(ed);
        this.txt_state.setEnabled(ed);
        this.txt_khasraNo.setEnabled(ed);
        this.txt_size.setEnabled(ed);
        this.txt_khataNo.setEnabled(ed);
        this.combo_ownerShare.setEnabled(ed);
        this.combo_landType.setEnabled(ed);
    }

    void setChainText() {
        if (this.channelHistories.size() > 0) {
            String chain = "The caption property belongs to ";
            for (final ChannelHistory channelHistory : this.channelHistories) {
                chain = chain + " " + channelHistory.toString() + " in favour of ";
            }
            chain = chain + this.txt_name.getText().trim() + " " + this.combo_fh.getSelectedItem().toString() + " " + this.txt_fhName.getText().trim() + ", " + this.txt_address.getText().trim();
            this.txt_chain.setText(chain);
        }
        else {
            this.txt_chain.setText("");
        }
    }

    void setChainTextAabadi() {
        if (this.documentLists.size() > 0) {
            String chain = "";
            if (this.documentLists.get(0).getDocumentName().toLowerCase().startsWith("conversion")) {
                chain = "The captioned property was a part of agriculture Land of khasra number " + this.documentLists.get(0).getDocumentNumber() + " belong to " + this.documentLists.get(0).getIssuedTo() + " they applied for conversion of this agriculture land to residential land according to " + this.documentLists.get(0).getIssuedBy() + " they converted this land from agriculture to residential land " + this.documentLists.get(0).getDocumentName() + " issued Date " + this.documentLists.get(0).getDate() + " ";
            }
            else {
                chain = "The captioned property belongs to " + this.documentLists.get(0).getIssuedBy() + ". The " + this.documentLists.get(0).getIssuedBy() + " has issued this " + this.documentLists.get(0).getDocumentName() + " number " + this.documentLists.get(0).getDocumentNumber() + " dated " + this.documentLists.get(0).getDate() + " in favour of " + this.documentLists.get(0).getIssuedTo();
            }
            chain = chain + " which was registered on dated " + this.documentLists.get(0).getRegisteredDate();
            for (int i = 1; i < this.documentLists.size(); ++i) {
                final DocumentList dlist = this.documentLists.get(i);
                chain += dlist.toString();
            }
            chain += ". The chain of title deed is not broken and title is clear.";
            this.txt_chainAabadi.setText(chain);
        }
        else {
            this.txt_chainAabadi.setText("");
        }
    }

    void clearPropertyFields() {
        this.txt_khasraNo.setText("");
        this.txt_size.setText("");
        this.txt_khataNo.setText("");
        this.combo_ownerShare.setSelectedIndex(0);
        this.txt_jamabandi.setValue(null);
        this.txt_girdawari.setValue(null);
        this.txt_tldate.setValue(null);
        this.txt_dlc.setText("");
        this.txt_patwariArea.setText("");
        this.txt_patwariVillage.setText("");
        this.combo_share.setSelectedItem("");
        this.txt_calculatedShare.setText("");
        this.combo_heldBy.requestFocus();
    }

    void clearChannelHistoryFields() {
        this.txt_historyName.setText("");
        this.txt_channelKhasra.setText("");
        this.txt_channelSize.setText("");
        this.txt_deedExecutionDate.setText("");
    }

    private void calculateShare() {
        final Object item = this.combo_share.getSelectedItem();
        String share = "";
        if (item == null) {
            share = "";
        }
        else {
            share = item.toString();
        }
        share = share.trim();
        final String size = this.txt_size.getText().trim();
        if (size.isEmpty()) {
            return;
        }
        float totalBigha = 0.0f;
        float totalBishwa = 0.0f;
        float shareCalculated = 0.0f;
        final String[] split;
        final String[] sizes = split = size.split(",");
        for (final String size2 : split) {
            final Float bigha = new Float(size2.split("-")[0]);
            final Float bishwah = new Float(size2.split("-")[1]);
            if (bigha != null) {
                totalBigha += bigha;
            }
            if (bishwah != null) {
                totalBishwa += bishwah;
            }
        }
        if (share.trim().isEmpty()) {
            final float clShare = 0.0f;
            shareCalculated = (totalBigha * 20.0f + totalBishwa) / 20.0f;
            shareCalculated = new Float(this.df.format(shareCalculated));
            this.txt_calculatedShare.setText("" + shareCalculated);
            return;
        }
        try {
            if (share.endsWith(" calculate")) {
                share = share.replaceAll(" calculate", "");
                float clShare = 0.0f;
                shareCalculated = (totalBigha * 20.0f + totalBishwa) / 20.0f;
                final String[] sh = share.split("/");
                final float a = new Float(sh[0].trim());
                final float b = new Float(sh[1].trim());
                final float calcShare = shareCalculated * a / b;
                clShare = new Float(this.df.format(calcShare));
                this.txt_calculatedShare.setText("" + this.df.format(clShare));
            }
            else if (share.endsWith(" calculated")) {
                share = share.replaceAll(" calculated", "");
                Float big = new Float(share.split("-")[0]);
                Float bis = new Float(share.split("-")[1]);
                if (big == null) {
                    big = 0.0f;
                }
                if (bis == null) {
                    bis = 0.0f;
                }
                else {
                    bis /= 20.0f;
                }
                final float calShare = big + bis;
                this.txt_calculatedShare.setText("" + this.df.format(calShare));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyStyle(final XWPFDocument srcDoc, final XWPFDocument destDoc, final XWPFStyle style) {
        if (destDoc == null || style == null) {
            return;
        }
        if (destDoc.getStyles() == null) {
            destDoc.createStyles();
        }
        final List<XWPFStyle> usedStyleList = (List<XWPFStyle>)srcDoc.getStyles().getUsedStyleList(style);
        for (final XWPFStyle xwpfStyle : usedStyleList) {
            destDoc.getStyles().addStyle(xwpfStyle);
        }
    }

    private static void copyLayout(final XWPFDocument srcDoc, final XWPFDocument destDoc) {
        final CTDocument1 document = srcDoc.getDocument();
        final CTBody body = document.getBody();
        final CTSectPr sectPr = body.getSectPr();
        final CTPageMar pgMar = srcDoc.getDocument().getBody().getSectPr().getPgMar();
        final BigInteger bottom = pgMar.getBottom();
        final BigInteger footer = pgMar.getFooter();
        final BigInteger gutter = pgMar.getGutter();
        final BigInteger header = pgMar.getHeader();
        final BigInteger left = pgMar.getLeft();
        final BigInteger right = pgMar.getRight();
        final BigInteger top = pgMar.getTop();
        final CTSectPr addNewSectPr = destDoc.getDocument().getBody().addNewSectPr();
        final CTPageMar addNewPgMar = addNewSectPr.addNewPgMar();
        addNewPgMar.setBottom(bottom);
        addNewPgMar.setFooter(footer);
        addNewPgMar.setGutter(gutter);
        addNewPgMar.setHeader(header);
        addNewPgMar.setLeft(left);
        addNewPgMar.setRight(right);
        addNewPgMar.setTop(top);
        final CTPageSz pgSzSrc = srcDoc.getDocument().getBody().getSectPr().getPgSz();
        final BigInteger code = pgSzSrc.getCode();
        final BigInteger h = pgSzSrc.getH();
        final STPageOrientation.Enum orient = pgSzSrc.getOrient();
        final BigInteger w = pgSzSrc.getW();
        final CTPageSz addNewPgSz = addNewSectPr.addNewPgSz();
        addNewPgSz.setCode(code);
        addNewPgSz.setH(h);
        addNewPgSz.setOrient(STPageOrientation.PORTRAIT);
        addNewPgSz.setW(w);
    }

    private void createHeaderFooter(final XWPFDocument document) throws IOException {
        final CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        final XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
        final CTP ctpFooter = CTP.Factory.newInstance();
        final CTPPr ctppr = ctpFooter.addNewPPr();
        final CTString pst = ctppr.addNewPStyle();
        pst.setVal("style21");
        final CTJc ctjc = ctppr.addNewJc();
        ctjc.setVal(STJc.RIGHT);
        ctppr.addNewRPr();
        CTR ctr = ctpFooter.addNewR();
        final CTText t = ctr.addNewT();
        t.setStringValue("");
        t.setSpace(SpaceAttribute.Space.PRESERVE);
        ctr = ctpFooter.addNewR();
        ctr.addNewRPr();
        final CTFldChar fch = ctr.addNewFldChar();
        fch.setFldCharType(STFldCharType.BEGIN);
        ctr = ctpFooter.addNewR();
        ctr.addNewInstrText().setStringValue(" PAGE ");
        ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
        ctpFooter.addNewR().addNewT().setStringValue("1");
        ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);
        final XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, (IBody)document);
        final XWPFParagraph[] parsFooter = { footerParagraph };
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
    }

    private void createReport() throws Exception {
        final XWPFDocument srcDoc = new XWPFDocument(AdvocateHelperUI.class.getResourceAsStream("/resources/" + this.searchMaster.getBank() + " Master.docx"));
        System.out.println("/resources/" + this.searchMaster.getBank() + " Master.docx");
        final CustomXWPFDocument destDoc = new CustomXWPFDocument();
        copyLayout(srcDoc, (XWPFDocument)destDoc);
        this.lastFile = this.pathPrefix + " " + this.searchMaster.getBank() + ".docx";
        final OutputStream out = new FileOutputStream(this.pathPrefix + " " + this.searchMaster.getBank() + ".docx");
        for (final IBodyElement bodyElement : srcDoc.getBodyElements()) {
            final BodyElementType elementType = bodyElement.getElementType();
            if (elementType == BodyElementType.PARAGRAPH) {
                final XWPFParagraph srcPr = (XWPFParagraph)bodyElement;
                copyStyle(srcDoc, (XWPFDocument)destDoc, srcDoc.getStyles().getStyle(srcPr.getStyleID()));
                final XWPFParagraph dstPr = destDoc.createParagraph();
                final int pos = destDoc.getParagraphs().size() - 1;
                final String pgTxt = srcPr.getParagraphText();
                final List<XWPFRun> runs = (List<XWPFRun>)srcPr.getRuns();
                if (runs != null) {
                    for (final XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null) {
                            text = this.textReplacer(text, this.properties.get(0));
                            r.setText(text, 0);
                        }
                    }
                }
                destDoc.setParagraph(srcPr, pos);
            }
            else {
                if (elementType != BodyElementType.TABLE) {
                    continue;
                }
                final XWPFTable table = (XWPFTable)bodyElement;
                copyStyle(srcDoc, (XWPFDocument)destDoc, srcDoc.getStyles().getStyle(table.getStyleID()));
                if (table.getText().contains("S.NO")) {
                    System.out.println(table.getNumberOfRows());
                    table.removeRow(2);
                    table.removeRow(2);
                    int applicantBigha = 0;
                    int applicantBishwa = 0;
                    int s = 1;
                    for (int k = 0; k < this.properties.size(); ++k) {
                        final Property property = this.properties.get(k);
                        final XWPFTableRow row = table.createRow();
                        row.createCell();
                        int i = 0;
                        final XWPFTableCell cell = row.getCell(i++);
                        final String[] sizes = property.getSize().split(",");
                        final XWPFTableCell cell2 = row.getCell(i++);
                        final String[] split;
                        final String[] khs = split = property.getKhasraNo().split(",");
                        for (final String kh : split) {
                            final XWPFParagraph paragrafo = cell.addParagraph();
                            paragrafo.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run1 = paragrafo.createRun();
                            run1.setFontFamily("Times New Roman");
                            run1.setFontSize(13);
                            run1.setText("" + s++);
                            final XWPFParagraph paragrafo2 = cell2.addParagraph();
                            paragrafo2.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo2.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run2 = paragrafo2.createRun();
                            run2.setFontFamily("Times New Roman");
                            run2.setFontSize(13);
                            run2.setText(kh);
                        }
                        final XWPFTableCell cell3 = row.getCell(i++);
                        final XWPFTableCell cell4 = row.getCell(i++);
                        for (final String size : sizes) {
                            final String[] bigbis = size.split("-");
                            final XWPFParagraph paragrafo3 = cell3.addParagraph();
                            paragrafo3.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo3.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run3 = paragrafo3.createRun();
                            run3.setFontFamily("Times New Roman");
                            run3.setFontSize(13);
                            run3.setText(bigbis[0]);
                            final XWPFParagraph paragrafo4 = cell4.addParagraph();
                            paragrafo4.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo4.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run4 = paragrafo4.createRun();
                            run4.setFontFamily("Times New Roman");
                            run4.setFontSize(13);
                            run4.setText(bigbis[1]);
                        }
                        final XWPFTableCell cell5 = row.getCell(i++);
                        final XWPFParagraph paragrafo5 = cell5.addParagraph();
                        paragrafo5.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo5.setVerticalAlignment(TextAlignment.CENTER);
                        final String own = property.getOwner();
                        String para5 = "";
                        final String csh = this.df.format(property.getShareCalculated());
                        final String[] bb = csh.split("\\.");
                        float bis = 0.0f;
                        if (bb.length == 2) {
                            if (bb[1].length() == 1) {
                                final StringBuilder sb = new StringBuilder();
                                final String[] array2 = bb;
                                final int n3 = 1;
                                array2[n3] = sb.append(array2[n3]).append("0").toString();
                            }
                            bis = Float.parseFloat(bb[1]);
                        }
                        else {
                            bis = 0.0f;
                        }
                        applicantBigha += Integer.parseInt(bb[0]);
                        bis /= 5.0f;
                        final String s2 = this.df4.format(bis);
                        applicantBishwa += this.df4.parse(s2).intValue();
                        if (applicantBishwa > 19) {
                            do {
                                ++applicantBigha;
                                applicantBishwa -= 20;
                            } while (applicantBishwa > 19);
                        }
                        if (own.startsWith("Exclusive")) {
                            para5 = "Applicant is Exclusive owner of this land ";
                        }
                        else {
                            para5 = "Applicant has " + bb[0] + " Bigha " + this.df4.parse(s2).intValue() + " Bishwa share in this land ";
                        }
                        para5 = para5 + "which is situated at Village:" + property.getVillage() + ", Tehsil:" + property.getTehsil() + ", District:" + property.getDistrict() + ", State:" + property.getState();
                        final XWPFRun run5 = paragrafo5.createRun();
                        run5.setFontFamily("Times New Roman");
                        run5.setFontSize(10);
                        run5.setText(para5);
                    }
                    final XWPFTableRow row2 = table.createRow();
                    final XWPFTableCell cell6 = row2.createCell();
                    int j = 0;
                    row2.getCell(j++).addParagraph();
                    final XWPFParagraph paragrafo6 = row2.getCell(j++).addParagraph();
                    paragrafo6.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo6.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run6 = paragrafo6.createRun();
                    run6.setFontFamily("Times New Roman");
                    run6.setFontSize(13);
                    run6.setBold(true);
                    run6.setText("Total");
                    final XWPFParagraph paragrafo7 = row2.getCell(j++).addParagraph();
                    paragrafo7.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo7.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run7 = paragrafo7.createRun();
                    run7.setFontFamily("Times New Roman");
                    run7.setFontSize(13);
                    run7.setBold(true);
                    run7.setText("" + this.totalBigha);
                    final XWPFParagraph paragrafo8 = row2.getCell(j++).addParagraph();
                    paragrafo8.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo8.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run8 = paragrafo8.createRun();
                    run8.setFontFamily("Times New Roman");
                    run8.setFontSize(13);
                    run8.setBold(true);
                    if (this.totalBishwa < 10) {
                        run8.setText("0" + this.totalBishwa);
                    }
                    else {
                        run8.setText("" + this.totalBishwa);
                    }
                    final XWPFParagraph paragrafo9 = row2.getCell(j).addParagraph();
                    paragrafo9.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo9.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run9 = paragrafo9.createRun();
                    run9.setFontFamily("Times New Roman");
                    run9.setFontSize(13);
                    run9.setBold(true);
                    run9.setText("Applicant total Share " + applicantBigha + " Bigha " + applicantBishwa + " Bishwa");
                    final XWPFParagraph paragrafo10 = row2.getCell(j).addParagraph();
                    paragrafo10.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo10.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run10 = paragrafo10.createRun();
                    run10.setFontFamily("Times New Roman");
                    run10.setFontSize(9);
                    run10.setBold(true);
                    run10.setText("Total Acres " + this.df3.format(this.totalAcres));
                }
                else if (table.getText().contains("AXDDPR")) {
                    System.out.println(table.getNumberOfRows());
                    table.removeRow(1);
                    int applicantBigha = 0;
                    int applicantBishwa = 0;
                    int s = 1;
                    for (int k = 0; k < this.properties.size(); ++k) {
                        final Property property = this.properties.get(k);
                        final XWPFTableRow row = table.createRow();
                        int i = 0;
                        final XWPFTableCell cell7 = row.getCell(i++);
                        final XWPFTableCell cell8 = row.getCell(i++);
                        final XWPFTableCell cell9 = row.getCell(i++);
                        final XWPFTableCell cell10 = row.getCell(i++);
                        final XWPFTableCell cell11 = row.getCell(i++);
                        final XWPFTableCell cell12 = row.getCell(i++);
                        final XWPFParagraph paragrafo11 = cell7.addParagraph();
                        paragrafo11.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo11.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run11 = paragrafo11.createRun();
                        run11.setFontFamily("Times New Roman");
                        run11.setFontSize(13);
                        run11.setText("" + s++);
                        final XWPFParagraph paragrafo12 = cell8.addParagraph();
                        paragrafo12.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo12.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run12 = paragrafo12.createRun();
                        run12.setFontFamily("Times New Roman");
                        run12.setFontSize(13);
                        run12.setText("Village:" + property.getVillage() + ", Tehsil:" + property.getTehsil() + ", District:" + property.getDistrict() + ", State:" + property.getState());
                        final XWPFParagraph paragrafo13 = cell9.addParagraph();
                        paragrafo13.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo13.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run13 = paragrafo13.createRun();
                        run13.setFontFamily("Times New Roman");
                        run13.setFontSize(13);
                        run13.setText("" + property.getKhataNo());
                        final String[] split2;
                        final String[] khs2 = split2 = property.getKhasraNo().split(",");
                        for (final String kh2 : split2) {
                            final XWPFParagraph paragrafo14 = cell10.addParagraph();
                            paragrafo14.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo14.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run14 = paragrafo14.createRun();
                            run14.setFontFamily("Times New Roman");
                            run14.setFontSize(13);
                            run14.setText(kh2);
                        }
                        final String[] split3;
                        final String[] sizes2 = split3 = property.getSize().split(",");
                        for (final String size2 : split3) {
                            final XWPFParagraph paragrafo15 = cell11.addParagraph();
                            paragrafo15.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo15.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run15 = paragrafo15.createRun();
                            run15.setFontFamily("Times New Roman");
                            run15.setFontSize(13);
                            run15.setText(size2);
                        }
                        final XWPFParagraph paragrafo16 = cell12.addParagraph();
                        paragrafo16.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo16.setVerticalAlignment(TextAlignment.CENTER);
                        final String own2 = property.getOwner();
                        String para6 = "";
                        final String csh2 = this.df.format(property.getShareCalculated());
                        final String[] bb2 = csh2.split("\\.");
                        float bis2 = 0.0f;
                        if (bb2.length == 2) {
                            if (bb2[1].length() == 1) {
                                final StringBuilder sb2 = new StringBuilder();
                                final String[] array3 = bb2;
                                final int n6 = 1;
                                array3[n6] = sb2.append(array3[n6]).append("0").toString();
                            }
                            bis2 = Float.parseFloat(bb2[1]);
                        }
                        else {
                            bis2 = 0.0f;
                        }
                        applicantBigha += Integer.parseInt(bb2[0]);
                        bis2 /= 5.0f;
                        final String s3 = this.df4.format(bis2);
                        applicantBishwa += this.df4.parse(s3).intValue();
                        if (applicantBishwa > 19) {
                            do {
                                ++applicantBigha;
                                applicantBishwa -= 20;
                            } while (applicantBishwa > 19);
                        }
                        if (own2.startsWith("Exclusive")) {
                            para6 = "Applicant is Exclusive owner of this land ";
                        }
                        else {
                            para6 = "Applicant has " + bb2[0] + " Bigha " + this.df4.parse(s3).intValue() + " Bishwa share in this land";
                        }
                        final XWPFRun run16 = paragrafo16.createRun();
                        run16.setFontFamily("Times New Roman");
                        run16.setFontSize(13);
                        run16.setText(para6);
                    }
                    final XWPFTableRow row2 = table.createRow();
                    int l = 0;
                    row2.getCell(l++).addParagraph();
                    ++l;
                    ++l;
                    final XWPFParagraph paragrafo17 = row2.getCell(l++).addParagraph();
                    paragrafo17.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo17.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run17 = paragrafo17.createRun();
                    run17.setFontFamily("Times New Roman");
                    run17.setFontSize(13);
                    run17.setBold(true);
                    run17.setText("Total");
                    final XWPFParagraph paragrafo18 = row2.getCell(l++).addParagraph();
                    paragrafo18.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo18.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run18 = paragrafo18.createRun();
                    run18.setFontFamily("Times New Roman");
                    run18.setFontSize(13);
                    run18.setBold(true);
                    String tb = "";
                    if (this.totalBishwa < 10) {
                        tb = "0" + this.totalBishwa;
                    }
                    else {
                        tb = "" + this.totalBishwa;
                    }
                    run18.setText("" + this.totalBigha + "-" + tb);
                    final XWPFParagraph paragrafo19 = row2.getCell(l).addParagraph();
                    paragrafo19.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo19.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run19 = paragrafo19.createRun();
                    run19.setFontFamily("Times New Roman");
                    run19.setFontSize(13);
                    run19.setBold(true);
                    run19.setText("Applicant total Share " + applicantBigha + " Bigha " + applicantBishwa + " Bishwa");
                    run19.addBreak();
                    run19.setText("Total Acres " + this.df3.format(this.totalAcres));
                }
                else if (table.getText().contains("DETAILS")) {
                    table.removeRow(1);
                    final XWPFTableRow row3 = table.createRow();
                    int m = 0;
                    final XWPFParagraph paragrafo20 = row3.getCell(m++).addParagraph();
                    paragrafo20.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo20.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run20 = paragrafo20.createRun();
                    run20.setFontFamily("Times New Roman");
                    run20.setFontSize(10);
                    run20.setText(this.applicantInfo.getName() + " " + this.applicantInfo.getFh() + " " + this.applicantInfo.getFhName() + " by cast " + this.applicantInfo.getSirName() + " Residence at " + this.applicantInfo.getAddress());
                    final XWPFTableCell cell13 = row3.getCell(m++);
                    final XWPFTableCell cell14 = row3.getCell(m++);
                    final XWPFTableCell cell15 = row3.getCell(m++);
                    final XWPFTableCell cell16 = row3.getCell(m++);
                    final XWPFTableCell cell17 = row3.getCell(m++);
                    final XWPFTableCell cell18 = row3.getCell(m++);
                    final XWPFTableCell cell19 = row3.getCell(m++);
                    for (final Map.Entry<String, HashMap<String, ArrayList<String[]>>> entry : this.pnbTable1.entrySet()) {
                        final String key = entry.getKey();
                        final HashMap<String, ArrayList<String[]>> value = entry.getValue();
                        final XWPFParagraph paragrafo21 = cell18.addParagraph();
                        paragrafo21.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo21.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run21 = paragrafo21.createRun();
                        run21.setFontFamily("Times New Roman");
                        run21.setFontSize(10);
                        run21.setText(key);
                        for (final Map.Entry<String, ArrayList<String[]>> entry2 : value.entrySet()) {
                            final String key2 = entry2.getKey();
                            final ArrayList<String[]> value2 = entry2.getValue();
                            final XWPFParagraph paragrafo22 = cell13.addParagraph();
                            paragrafo22.setAlignment(ParagraphAlignment.CENTER);
                            paragrafo22.setVerticalAlignment(TextAlignment.CENTER);
                            final XWPFRun run22 = paragrafo22.createRun();
                            run22.setFontFamily("Times New Roman");
                            run22.setFontSize(10);
                            run22.setText(key2);
                            for (final String[] khasraSize : value2) {
                                final String[] kh3 = khasraSize[0].split(",");
                                final String[] sz = khasraSize[1].split(",");
                                boolean first = true;
                                for (int x = 0; x < sz.length; ++x) {
                                    if (first) {
                                        first = false;
                                    }
                                    else {
                                        cell13.addParagraph();
                                    }
                                    final String size3 = sz[x];
                                    final String khs3 = kh3[x];
                                    final XWPFParagraph paragrafo23 = cell14.addParagraph();
                                    paragrafo23.setAlignment(ParagraphAlignment.CENTER);
                                    paragrafo23.setVerticalAlignment(TextAlignment.CENTER);
                                    final XWPFRun run23 = paragrafo23.createRun();
                                    run23.setFontFamily("Times New Roman");
                                    run23.setFontSize(10);
                                    run23.setText(khs3);
                                    final XWPFParagraph paragrafo24 = cell15.addParagraph();
                                    paragrafo24.setAlignment(ParagraphAlignment.CENTER);
                                    paragrafo24.setVerticalAlignment(TextAlignment.CENTER);
                                    final XWPFRun run24 = paragrafo24.createRun();
                                    run24.setFontFamily("Times New Roman");
                                    run24.setFontSize(10);
                                    run24.setText(size3);
                                }
                            }
                        }
                    }
                    final XWPFParagraph paragrafo25 = cell16.addParagraph();
                    paragrafo25.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo25.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run25 = paragrafo25.createRun();
                    run25.setFontFamily("Times New Roman");
                    run25.setFontSize(10);
                    run25.setText("As per Revenue map");
                    final XWPFParagraph paragrafo26 = cell17.addParagraph();
                    paragrafo26.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo26.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run26 = paragrafo26.createRun();
                    run26.setFontFamily("Times New Roman");
                    run26.setFontSize(10);
                    run26.setText("As par Jamabandi");
                    final XWPFParagraph paragrafo27 = cell19.addParagraph();
                    paragrafo27.setAlignment(ParagraphAlignment.CENTER);
                    paragrafo27.setVerticalAlignment(TextAlignment.CENTER);
                    final XWPFRun run27 = paragrafo27.createRun();
                    run27.setFontFamily("Times New Roman");
                    run27.setFontSize(10);
                    run27.setText("As par schedule\u2013I  enclosed");
                }
                else if (table.getText().contains("Nature (Original/ Copy sale Deed/Lease Deed/GPA/SPA./ Will / Relinquishment Deed")) {
                    table.removeRow(1);
                    for (int i2 = 0; i2 < this.channelHistories.size(); ++i2) {
                        final XWPFTableRow row4 = table.createRow();
                        final ChannelHistory chHistory = this.channelHistories.get(i2);
                        final XWPFParagraph paragrafo28 = row4.getCell(0).addParagraph();
                        paragrafo28.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo28.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run28 = paragrafo28.createRun();
                        run28.setFontFamily("Times New Roman");
                        run28.setFontSize(11);
                        run28.setText(i2 + 1 + "");
                        final XWPFParagraph paragrafo29 = row4.getCell(1).addParagraph();
                        paragrafo29.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo29.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run29 = paragrafo29.createRun();
                        run29.setFontFamily("Times New Roman");
                        run29.setFontSize(11);
                        run29.setText("Registered");
                        final XWPFParagraph paragrafo30 = row4.getCell(2).addParagraph();
                        paragrafo30.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo30.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run30 = paragrafo30.createRun();
                        run30.setFontFamily("Times New Roman");
                        run30.setFontSize(11);
                        run30.setText(chHistory.getName());
                        final XWPFParagraph paragrafo31 = row4.getCell(3).addParagraph();
                        paragrafo31.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo31.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run31 = paragrafo31.createRun();
                        run31.setFontFamily("Times New Roman");
                        run31.setFontSize(11);
                        if (i2 + 1 == this.channelHistories.size()) {
                            run31.setText(this.searchMaster.getApplicantInfo().getName() + " " + this.searchMaster.getApplicantInfo().getFh() + " " + this.searchMaster.getApplicantInfo().getFhName());
                        }
                        else {
                            run31.setText(this.channelHistories.get(i2 + 1).getName());
                        }
                        final XWPFParagraph paragrafo32 = row4.getCell(4).addParagraph();
                        paragrafo32.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo32.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run32 = paragrafo32.createRun();
                        run32.setFontFamily("Times New Roman");
                        run32.setFontSize(11);
                        run32.setText(chHistory.getDeedDate());
                        final XWPFParagraph paragrafo33 = row4.getCell(5).addParagraph();
                        paragrafo33.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo33.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run33 = paragrafo33.createRun();
                        run33.setFontFamily("Times New Roman");
                        run33.setFontSize(11);
                        run33.setText(chHistory.getNature());
                        final XWPFParagraph paragrafo34 = row4.getCell(6).addParagraph();
                        paragrafo34.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo34.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run34 = paragrafo34.createRun();
                        run34.setFontFamily("Times New Roman");
                        run34.setFontSize(11);
                        run34.setText(chHistory.getSize());
                    }
                }
                else {
                    int rw = 0;
                    for (final XWPFTableRow row5 : table.getRows()) {
                        int cl = 0;
                        for (final XWPFTableCell cell20 : row5.getTableCells()) {
                            for (final XWPFParagraph p : cell20.getParagraphs()) {
                                final String str = p.getText();
                                if (rw == 3 && cl == 1 && !table.getText().contains("ADVOCATENAME") && this.searchMaster.getBank().equals("UCO") && !table.getText().contains("REFNO") && !table.getText().contains("MNO")) {
                                    final ArrayList<String> adrs = new ArrayList<String>();
                                    for (final Property property2 : this.properties) {
                                        final XWPFRun runAddr = p.createRun();
                                        runAddr.setFontFamily("Times New Roman");
                                        runAddr.setFontSize(10);
                                        final String addr = "Village:" + property2.getVillage();
                                        if (!adrs.contains(addr)) {
                                            adrs.add(addr);
                                            runAddr.setText(addr);
                                            runAddr.addBreak();
                                        }
                                        final String[] khasras = property2.getKhasraNo().split(",");
                                        final String[] sizes3 = property2.getSize().split(",");
                                        int applicantBigha2 = 0;
                                        int applicantBishwa2 = 0;
                                        final String csh3 = this.df.format(property2.getShareCalculated());
                                        final String[] bb3 = csh3.split("\\.");
                                        float bis3 = 0.0f;
                                        if (bb3.length == 2) {
                                            if (bb3[1].length() == 1) {
                                                final StringBuilder sb3 = new StringBuilder();
                                                final String[] array4 = bb3;
                                                final int n7 = 1;
                                                array4[n7] = sb3.append(array4[n7]).append("0").toString();
                                            }
                                            bis3 = Float.parseFloat(bb3[1]);
                                        }
                                        else {
                                            bis3 = 0.0f;
                                        }
                                        applicantBigha2 += Integer.parseInt(bb3[0]);
                                        bis3 /= 5.0f;
                                        final String s4 = this.df4.format(bis3);
                                        applicantBishwa2 += this.df4.parse(s4).intValue();
                                        for (int i3 = 0; i3 < sizes3.length; ++i3) {
                                            final XWPFRun dtr = p.createRun();
                                            dtr.setFontFamily("Times New Roman");
                                            dtr.setFontSize(10);
                                            dtr.setText("Kha.No " + khasras[i3] + " Rakba " + sizes3[i3].split("-")[0] + " bigha " + sizes3[i3].split("-")[1] + " bishwa");
                                            dtr.addBreak();
                                        }
                                    }
                                }
                                else if (rw == 4 && cl == 2 && !table.getText().contains("HECT%") && this.searchMaster.getBank().equals("ICICI") && !table.getText().contains("APS ID NO") && !table.getText().contains("MNO")) {
                                    for (final Property property3 : this.properties) {
                                        final XWPFRun runAddr2 = p.createRun();
                                        runAddr2.setFontFamily("Times New Roman");
                                        runAddr2.setFontSize(10);
                                        final String addr2 = "Village:" + property3.getVillage() + ", Tehsil:" + property3.getTehsil() + ", District:" + property3.getDistrict() + ", State:" + property3.getState();
                                        runAddr2.setText(addr2);
                                        runAddr2.addBreak();
                                        final String[] khasras2 = property3.getKhasraNo().split(",");
                                        final String[] sizes4 = property3.getSize().split(",");
                                        int applicantBigha3 = 0;
                                        int applicantBishwa3 = 0;
                                        final String csh = this.df.format(property3.getShareCalculated());
                                        final String[] bb = csh.split("\\.");
                                        float bis = 0.0f;
                                        if (bb.length == 2) {
                                            if (bb[1].length() == 1) {
                                                final StringBuilder sb4 = new StringBuilder();
                                                final String[] array5 = bb;
                                                final int n8 = 1;
                                                array5[n8] = sb4.append(array5[n8]).append("0").toString();
                                            }
                                            bis = Float.parseFloat(bb[1]);
                                        }
                                        else {
                                            bis = 0.0f;
                                        }
                                        applicantBigha3 += Integer.parseInt(bb[0]);
                                        bis /= 5.0f;
                                        final String s2 = this.df4.format(bis);
                                        applicantBishwa3 += this.df4.parse(s2).intValue();
                                        for (int i4 = 0; i4 < sizes4.length; ++i4) {
                                            final XWPFRun dtr2 = p.createRun();
                                            dtr2.setFontFamily("Times New Roman");
                                            dtr2.setFontSize(10);
                                            dtr2.setText("Kha.No " + khasras2[i4] + " Rakba " + sizes4[i4].split("-")[0] + " bigha " + sizes4[i4].split("-")[1] + " bishwa");
                                            dtr2.addBreak();
                                        }
                                        final XWPFRun dtr3 = p.createRun();
                                        dtr3.setFontFamily("Times New Roman");
                                        dtr3.setFontSize(10);
                                        dtr3.setText("Applicant has " + applicantBigha3 + " Bigha " + applicantBishwa3 + " Bishwa Share in this " + property3.getLandType() + " land");
                                        dtr3.addBreak();
                                    }
                                }
                                else if (rw == 6 && cl == 2 && this.searchMaster.getBank().equals("SBI") && !table.getText().contains("REFNO") && !table.getText().contains("MNO")) {
                                    for (final Property property3 : this.properties) {
                                        final XWPFRun runAddr2 = p.createRun();
                                        runAddr2.setFontFamily("Times New Roman");
                                        runAddr2.setFontSize(10);
                                        final String addr2 = "Village:" + property3.getVillage() + ", Tehsil:" + property3.getTehsil() + ", District:" + property3.getDistrict() + ", State:" + property3.getState();
                                        runAddr2.setText(addr2);
                                        runAddr2.addBreak();
                                        final String[] khasras2 = property3.getKhasraNo().split(",");
                                        final String[] sizes4 = property3.getSize().split(",");
                                        int applicantBigha3 = 0;
                                        int applicantBishwa3 = 0;
                                        final String csh = this.df.format(property3.getShareCalculated());
                                        final String[] bb = csh.split("\\.");
                                        float bis = 0.0f;
                                        if (bb.length == 2) {
                                            if (bb[1].length() == 1) {
                                                final StringBuilder sb5 = new StringBuilder();
                                                final String[] array6 = bb;
                                                final int n9 = 1;
                                                array6[n9] = sb5.append(array6[n9]).append("0").toString();
                                            }
                                            bis = Float.parseFloat(bb[1]);
                                        }
                                        else {
                                            bis = 0.0f;
                                        }
                                        applicantBigha3 += Integer.parseInt(bb[0]);
                                        bis /= 5.0f;
                                        final String s2 = this.df4.format(bis);
                                        applicantBishwa3 += this.df4.parse(s2).intValue();
                                        for (int i4 = 0; i4 < sizes4.length; ++i4) {
                                            final XWPFRun dtr2 = p.createRun();
                                            dtr2.setFontFamily("Times New Roman");
                                            dtr2.setFontSize(10);
                                            dtr2.setText("Kha.No " + khasras2[i4] + " Rakba " + sizes4[i4].split("-")[0] + " bigha " + sizes4[i4].split("-")[1] + " bishwa");
                                            dtr2.addBreak();
                                        }
                                        final XWPFRun dtr3 = p.createRun();
                                        dtr3.setFontFamily("Times New Roman");
                                        dtr3.setFontSize(10);
                                        dtr3.setText("Applicant has " + applicantBigha3 + " Bigha " + applicantBishwa3 + " Bishwa Share in this " + property3.getLandType() + " land");
                                        dtr3.addBreak();
                                    }
                                    if (rw != 3) {
                                        continue;
                                    }
                                    final XWPFRun runAddr3 = p.createRun();
                                    runAddr3.setFontFamily("Times New Roman");
                                    runAddr3.setFontSize(10);
                                    final String tp = "in the name of " + this.searchMaster.getApplicantInfo().getName() + " " + this.searchMaster.getApplicantInfo().getFh() + " " + this.searchMaster.getApplicantInfo().getFhName() + " his share is offering for security";
                                    runAddr3.setText(tp);
                                }
                                else {
                                    for (final XWPFRun r2 : p.getRuns()) {
                                        String text2 = r2.getText(0);
                                        if (text2 != null) {
                                            System.out.println(r2.getFontFamily());
                                            String font = r2.getFontFamily();
                                            font = ((font == null) ? "" : font);
                                            if (font.toLowerCase().startsWith("kruti")) {
                                                r2.setFontFamily(font);
                                            }
                                            else {
                                                r2.setFontFamily("Times New Roman");
                                            }
                                            text2 = this.textReplacer(text2, this.properties.get(0));
                                        }
                                        else {
                                            text2 = "";
                                        }
                                        r2.setText(text2, 0);
                                    }
                                }
                            }
                            ++cl;
                        }
                        ++rw;
                    }
                }
                destDoc.createTable();
                final int pos2 = destDoc.getTables().size() - 1;
                destDoc.setTable(pos2, table);
            }
        }
        this.createHeaderFooter((XWPFDocument)destDoc);
        destDoc.write(out);
        out.close();
        System.out.println("Report created");
    }

    private void createReportAabadi() throws Exception {
        final XWPFDocument srcDoc = new XWPFDocument(AdvocateHelperUI.class.getResourceAsStream("/resources/Aabadi/" + this.searchMaster.getBank() + " AABADI.docx"));
        System.out.println("/resources/Aabadi/" + this.searchMaster.getBank() + " AABADI.docx");
        final CustomXWPFDocument destDoc = new CustomXWPFDocument();
        copyLayout(srcDoc, (XWPFDocument)destDoc);
        this.lastFile = this.pathPrefix + " Aabadi " + this.searchMaster.getBank() + ".docx";
        final OutputStream out = new FileOutputStream(this.pathPrefix + " Aabadi " + this.searchMaster.getBank() + ".docx");
        for (final IBodyElement bodyElement : srcDoc.getBodyElements()) {
            final BodyElementType elementType = bodyElement.getElementType();
            if (elementType == BodyElementType.PARAGRAPH) {
                final XWPFParagraph srcPr = (XWPFParagraph)bodyElement;
                copyStyle(srcDoc, (XWPFDocument)destDoc, srcDoc.getStyles().getStyle(srcPr.getStyleID()));
                final XWPFParagraph dstPr = destDoc.createParagraph();
                final int pos = destDoc.getParagraphs().size() - 1;
                final String pgTxt = srcPr.getParagraphText();
                final List<XWPFRun> runs = (List<XWPFRun>)srcPr.getRuns();
                if (runs != null) {
                    for (final XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null) {
                            text = this.textReplacerAabadi(text);
                            r.setText(text, 0);
                        }
                    }
                }
                destDoc.setParagraph(srcPr, pos);
            }
            else {
                if (elementType != BodyElementType.TABLE) {
                    continue;
                }
                final XWPFTable table = (XWPFTable)bodyElement;
                copyStyle(srcDoc, (XWPFDocument)destDoc, srcDoc.getStyles().getStyle(table.getStyleID()));
                if (table.getText().contains("Nature (Original/ Copy sale Deed/Lease Deed/GPA/SPA./ Will / Relinquishment Deed")) {
                    table.removeRow(1);
                    for (int i = 0; i < this.documentLists.size(); ++i) {
                        final XWPFTableRow row = table.createRow();
                        final DocumentList dList = this.documentLists.get(i);
                        final XWPFParagraph paragrafo = row.getCell(0).addParagraph();
                        paragrafo.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run = paragrafo.createRun();
                        run.setFontFamily("Times New Roman");
                        run.setFontSize(11);
                        run.setText(i + 1 + "");
                        final XWPFParagraph paragrafo2 = row.getCell(1).addParagraph();
                        paragrafo2.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo2.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run2 = paragrafo2.createRun();
                        run2.setFontFamily("Times New Roman");
                        run2.setFontSize(11);
                        run2.setText("Registered");
                        final XWPFParagraph paragrafo3 = row.getCell(2).addParagraph();
                        paragrafo3.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo3.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run3 = paragrafo3.createRun();
                        run3.setFontFamily("Times New Roman");
                        run3.setFontSize(11);
                        run3.setText(dList.getIssuedBy());
                        final XWPFParagraph paragrafo4 = row.getCell(3).addParagraph();
                        paragrafo4.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo4.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run4 = paragrafo4.createRun();
                        run4.setFontFamily("Times New Roman");
                        run4.setFontSize(11);
                        run4.setText(dList.getIssuedTo());
                        final XWPFParagraph paragrafo5 = row.getCell(4).addParagraph();
                        paragrafo5.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo5.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run5 = paragrafo5.createRun();
                        run5.setFontFamily("Times New Roman");
                        run5.setFontSize(11);
                        run5.setText(dList.getDate());
                        final XWPFParagraph paragrafo6 = row.getCell(5).addParagraph();
                        paragrafo6.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo6.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run6 = paragrafo6.createRun();
                        run6.setFontFamily("Times New Roman");
                        run6.setFontSize(11);
                        run6.setText(dList.getDocumentName());
                        final XWPFParagraph paragrafo7 = row.getCell(6).addParagraph();
                        paragrafo7.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo7.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run7 = paragrafo7.createRun();
                        run7.setFontFamily("Times New Roman");
                        run7.setFontSize(11);
                        run7.setText(this.sizeAabadi);
                    }
                }
                else if (table.getText().contains("ABDICICIDOCLST")) {
                    table.removeRow(1);
                    for (int i = 0; i < this.documentLists.size(); ++i) {
                        final XWPFTableRow row = table.createRow();
                        final DocumentList dList = this.documentLists.get(i);
                        final XWPFParagraph paragrafo = row.getCell(0).addParagraph();
                        paragrafo.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run = paragrafo.createRun();
                        run.setFontFamily("Times New Roman");
                        run.setFontSize(11);
                        run.setText(i + 1 + "");
                        final XWPFParagraph paragrafo2 = row.getCell(1).addParagraph();
                        paragrafo2.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo2.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run2 = paragrafo2.createRun();
                        run2.setFontFamily("Times New Roman");
                        run2.setFontSize(11);
                        run2.setText(dList.getDocumentName());
                        final XWPFParagraph paragrafo3 = row.getCell(2).addParagraph();
                        paragrafo3.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo3.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run3 = paragrafo3.createRun();
                        run3.setFontFamily("Times New Roman");
                        run3.setFontSize(11);
                        run3.setText(dList.getDate());
                        final XWPFParagraph paragrafo4 = row.getCell(3).addParagraph();
                        paragrafo4.setAlignment(ParagraphAlignment.CENTER);
                        paragrafo4.setVerticalAlignment(TextAlignment.CENTER);
                        final XWPFRun run4 = paragrafo4.createRun();
                        run4.setFontFamily("Times New Roman");
                        run4.setFontSize(11);
                        run4.setText(dList.getRequired());
                    }
                }
                else {
                    for (final XWPFTableRow row : table.getRows()) {
                        for (final XWPFTableCell cell : row.getTableCells()) {
                            for (final XWPFParagraph p : cell.getParagraphs()) {
                                for (final XWPFRun r2 : p.getRuns()) {
                                    String text2 = r2.getText(0);
                                    if (text2 != null) {
                                        String font = r2.getFontFamily();
                                        font = ((font == null) ? "" : font);
                                        if (font.toLowerCase().startsWith("kruti")) {
                                            r2.setFontFamily(font);
                                        }
                                        else {
                                            r2.setFontFamily("Times New Roman");
                                        }
                                        if (text2.contains("ABDFDOCLST")) {
                                            final boolean endsWith = text2.trim().endsWith("ABDFDOCLST");
                                            final String[] split = text2.split("ABDFDOCLST");
                                            r2.setText("", 0);
                                            for (int j = 0; j < split.length; ++j) {
                                                split[j] = this.textReplacerAabadi(split[j]);
                                                if (j == 0) {
                                                    r2.setText(split[j], 0);
                                                }
                                                else {
                                                    r2.setText(split[j]);
                                                }
                                                final String[] fdlsts = this.fullDetailOfDocumentsAabadi.split("\\{\\$\\}");
                                                r2.addBreak();
                                                for (int k = 0; k < fdlsts.length; ++k) {
                                                    r2.setText(k + 1 + ". " + fdlsts[k]);
                                                    r2.addBreak();
                                                }
                                            }
                                            if (!endsWith) {
                                                continue;
                                            }
                                            final String[] fdlsts2 = this.fullDetailOfDocumentsAabadi.split("\\{\\$\\}");
                                            r2.addBreak();
                                            for (int l = 0; l < fdlsts2.length; ++l) {
                                                r2.setText(l + 1 + ". " + fdlsts2[l]);
                                                r2.addBreak();
                                            }
                                        }
                                        else {
                                            text2 = this.textReplacerAabadi(text2);
                                            r2.setText(text2, 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                destDoc.createTable();
                final int pos2 = destDoc.getTables().size() - 1;
                destDoc.setTable(pos2, table);
            }
        }
        this.createHeaderFooter((XWPFDocument)destDoc);
        destDoc.write(out);
        out.close();
        System.out.println("Report created");
    }

    void prepareReports() throws Exception {
        if (this.menu_switchToAabadi.isSelected()) {
            this.initializeVariablesAabadi();
        }
        else {
            this.initializeVariables();
        }
        this.pathPrefix = "Output/";
        this.pathPrefix = this.pathPrefix + this.selectedBank + "/";
        this.pathPrefix = this.pathPrefix + this.searchMaster.getSno() + " ";
        this.pathPrefix += this.searchMaster.getDateOfSearch().replace("/", "-");
        this.pathPrefix = this.pathPrefix + " " + this.applicantInfo.getName().replace("/", "-");
        this.pathPrefix = this.pathPrefix + " " + this.selectedBank.replace("/", "-");
        this.pathPrefix = this.pathPrefix + " " + this.searchMaster.getBranch().replace("/", "-");
        if (this.menu_switchToAabadi.isSelected()) {
            this.createReportAabadi();
        }
        else {
            this.createReport();
        }
    }

    void storeData() {
        System.out.println("Update : " + this.dbHandler.updateWithSNO("" + this.searchMaster.getSno()));
        System.out.println("Search Master : " + this.dbHandler.insert((Object)this.searchMaster));
        final ApplicantInfo appInfo = this.searchMaster.getApplicantInfo();
        appInfo.setSno((int)this.searchMaster.getSno());
        System.out.println("Applicant Info : " + this.dbHandler.insert((Object)appInfo));
        if (!this.menu_switchToAabadi.isSelected()) {
            final ArrayList<Property> properties1 = (ArrayList<Property>)appInfo.getProperties();
            for (final Property property : properties1) {
                property.setSno(Integer.valueOf(appInfo.getSno()));
                System.out.println("Property : " + this.dbHandler.insert((Object)property));
            }
            for (final ChannelHistory channelHistory1 : this.channelHistories) {
                channelHistory1.setSno(appInfo.getSno());
                System.out.println("Channel History : " + this.dbHandler.insert((Object)channelHistory1));
            }
        }
        else {
            final AabadiProperty ap = appInfo.getAabadiProperty();
            ap.setSno((int)this.searchMaster.getSno());
            System.out.println("Aabadi Property : " + this.dbHandler.insert((Object)ap));
            final ArrayList<DocumentList> documentLists1 = (ArrayList<DocumentList>)appInfo.getDocumentLists();
            for (final DocumentList dl : documentLists1) {
                dl.setSno((int)this.searchMaster.getSno());
                System.out.println("Document List : " + this.dbHandler.insert((Object)dl));
            }
        }
    }

    public void setLogo() {
        if (this.selectedBank == null) {
            return;
        }
        String filename = "";
        final String lowerCase = this.selectedBank.toLowerCase();
        switch (lowerCase) {
            case "bob": {
                filename = "bob.gif";
                break;
            }
            case "icici": {
                filename = "icici.png";
                break;
            }
            case "pnb": {
                filename = "pnb.png";
                break;
            }
            case "uco": {
                filename = "uco.jpg";
                break;
            }
            case "union": {
                filename = "union.jpg";
                break;
            }
            case "rmgb": {
                filename = "rmgb.jpg";
                break;
            }
            case "aufinance": {
                filename = "aufinance.jpg";
                break;
            }
            case "axis": {
                filename = "axis.jpg";
                break;
            }
            case "boi": {
                filename = "boi.jpg";
                break;
            }
            case "hdfc": {
                filename = "hdfc.jpg";
                break;
            }
            case "indusind": {
                filename = "indusind.jpg";
                break;
            }
            case "obc": {
                filename = "obc.jpg";
                break;
            }
            case "sbi": {
                filename = "sbi.jpg";
                break;
            }
            case "yes": {
                filename = "yes.jpg";
                break;
            }
            default: {
                filename = "select.png";
                break;
            }
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(AdvocateHelperUI.class.getResourceAsStream("/resources/logo/" + filename));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final Image dimg = img.getScaledInstance(this.lbl_logo.getWidth(), this.lbl_logo.getHeight(), 4);
        final ImageIcon imageIcon = new ImageIcon(dimg);
        this.lbl_logo.setIcon(imageIcon);
    }

    private void calculatePeriod() {
        final String period = this.txt_searchPeriod.getText().trim();
        if (period.isEmpty()) {
            return;
        }
        final Matcher r = this.ptPeriod.matcher(period);
        if (!r.matches()) {
            this.txt_searchPeriod.getToolkit().beep();
            this.txt_searchPeriod.requestFocus();
            return;
        }
        final String[] split = period.split("-");
        final int from = Integer.parseInt(split[0]);
        final int to = Integer.parseInt(split[1]);
        this.tsrYear = Math.abs(to - from);
        ++this.tsrYear;
        this.tsrPeriod = period;
    }

    private String textReplacer(String text, final Property property) {
        text = text.replaceAll("(ADVOCATENAME)", this.searchMaster.getAdvocate());
        String mno;
        if (this.selectedAdvocate.equalsIgnoreCase("Chandan Singh Bhati")) {
            mno = "94144-40557";
        }
        else {
            mno = "94144-94726";
        }
        text = text.replace("MNO", mno);
        text = text.replace("DEEDDATE", this.lastSaleDeedDate);
        text = text.replaceAll("(DATE)", this.searchMaster.getDateOfSearch());
        text = text.replaceAll("(BRANCH)", this.searchMaster.getBranch());
        text = text.replaceAll("(BANK)", this.searchMaster.getBank());
        text = text.replaceAll("(BORROWER/GAURANTOR)", "BORROWER");
        text = text.replaceAll("(SNO)", "" + this.searchMaster.getSno());
        text = text.replaceAll("(NAME)", this.applicantInfo.getName());
        text = text.replace("FATHERHUSBAND", this.applicantInfo.getFhName());
        text = text.replaceAll("(FH)", this.applicantInfo.getFh());
        text = text.replaceAll("(CAST)", this.applicantInfo.getSirName());
        text = text.replaceAll("(ADDRESS)", this.applicantInfo.getAddress());
        text = text.replaceAll("(PROPERTIES)", this.propertyAddr);
        text = text.replaceAll("(LANDTYPE)", property.getLandType());
        text = text.replaceAll("(KHASRANOS)", this.khasraNos);
        text = text.replaceAll("(TOTALSHARE)", this.totalShare);
        text = text.replaceAll("(TTSH)", this.totalShare);
        text = text.replaceAll("(KHATANOS)", this.khataNos);
        text = text.replaceAll("(PADDRESS)", this.propertyAddr);
        text = text.replaceAll("(JAMABANDI)", this.jamabandiSmts);
        text = text.replaceAll("(JAMADT)", this.jamadts);
        text = text.replaceAll("(GIRDDT)", this.girddts);
        text = text.replaceAll("(GIRDAWARI)", this.girdawariSmts);
        text = text.replaceAll("(T.L.D.A.T.E)", this.tldates);
        if (!this.searchMaster.getBank().equals("ICICI")) {
            text = text.replaceAll("(REFNO)", this.searchMaster.getRefNo() + "_Bank:" + this.searchMaster.getBank());
        }
        else {
            text = text.replaceAll("(REFNO)", this.searchMaster.getRefNo());
        }
        text = text.replaceAll("(NMRFNO)", this.searchMaster.getRefNo());
        text = text.replaceAll("(TSRYEAR)", this.tsrYear + "");
        text = text.replaceAll("(TSRPERIOD)", this.tsrPeriod + "");
        text = text.replaceAll("(HECTARES)", this.df.format(this.totalHect));
        text = text.replaceAll("(HECTPERCENT)", this.df3.format(this.hectPercent) + "%");
        text = text.replaceAll("(HECTCALC)", "" + this.df3.format(this.appShareHect));
        text = text.replaceAll("(DLCTOTAL)", "Rs. " + this.totalDLC + " /-");
        text = text.replaceAll("(PADDRESS)", this.propertyAddr);
        text = text.replaceAll("(VILLAGES)", this.villages);
        text = text.replace("N1M1S1T1A1T1E1S", this.states);
        text = text.replace("N1M1D1I1S1T1R1I1C1T1S", this.districts);
        text = text.replace("TEHSILS", this.tehsils);
        text = text.replaceAll("(TOTALSIZE)", this.totalSize);
        text = text.replaceAll("(TOTALACRES)", this.df3.format(this.totalAcres));
        text = text.replace("ANCESTRAL/SELF-ACQUIRED", this.heldByStr);
        text = text.replaceAll("(ANCESTRAL/SELF-ACQUIRED)", this.heldByStr);
        if (this.txt_historyName.isEnabled()) {
            text = text.replaceAll("(CHAIN)", this.chains);
        }
        else if (this.searchMaster.getBank().equals("SBI")) {
            text = text.replaceAll("(NAME)", this.applicantInfo.getName());
            text = text.replace("FATHERHUSBAND", this.applicantInfo.getFhName());
            text = text.replaceAll("(FH)", this.applicantInfo.getFh());
            text = text.replaceAll("(CHAIN)", "Said agriculture land in the name of " + this.applicantInfo.getName() + " " + this.applicantInfo.getFh() + " " + this.applicantInfo.getFhName() + " and presently he is owner of his share in the said property");
        }
        else {
            text = text.replaceAll("(CHAIN)", "");
        }
        text = text.replace("SUBREGISTRAR", this.searchMaster.getSubRegistrar());
        text = text.replaceAll("(PATWARIVILLAGE)", this.patwariVillages);
        text = text.replaceAll("(PATWARIAREA)", this.patwariAreas);
        if (this.selectedBank.equals("UCO")) {
            if (this.alreadyMortgaged) {
                final String st = "This property duly mortgage with " + this.searchMaster.getMortgagedBank() + " bank " + this.searchMaster.getMortgagedBranch() + "";
                text = text.replaceAll("(ALREADYMORTGAGE)", st);
            }
            else {
                text = text.replaceAll("(ALREADYMORTGAGE)", "");
            }
        }
        if (this.selectedBank.equals("BOB")) {
            if (this.alreadyMortgaged) {
                final String st = "Encumbrance/charge on this land with Bank " + this.searchMaster.getMortgagedBank() + ", Branch " + this.searchMaster.getMortgagedBranch();
                text = text.replaceAll("(ALMTG)", st);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("PNB") || this.selectedBank.equals("RMGB")) {
            if (this.alreadyMortgaged) {
                text = text.replace("No any encumbrance /charge on this land", "Encumbrance /charge on this land");
                final String st = "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + ", I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " already encumbrance " + "on the said property . also search in the Sub registrars office at " + this.searchMaster.getSubRegistrar() + " Already Noted with " + "revenue authority mortgage registered in fovour of bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + " No any Break in the chain of title . Banks creation of mortgage over the property not vitiate.";
                text = text.replaceAll("(ALMTG)", st);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("OBC")) {
            if (this.alreadyMortgaged) {
                text = text.replaceAll("(ALREADYMORTGAGE)", "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch());
            }
            else {
                text = text.replaceAll("(ALREADYMORTGAGE)", "No any encumbrance/charge on this land");
            }
        }
        if (this.selectedBank.equals("SBI")) {
            if (this.alreadyMortgaged) {
                final String st = "Mortgaged with Bank " + this.searchMaster.getMortgagedBank() + ", Branch " + this.searchMaster.getMortgagedBranch();
                text = text.replaceAll("(ALMTG)", st);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("AXIS")) {
            if (this.alreadyMortgaged) {
                final String st = this.searchMaster.getMortgagedBank() + " Bank, " + this.searchMaster.getMortgagedBranch() + " Branch";
                text = text.replaceAll("(ALREADYMORTGAGE)", st);
                text = text.replaceAll("(ALMTGAD)", "after discharge of");
                text = text.replaceAll("(ALMTGEX)", "except the");
                text = text.replaceAll("(ALMTGYN)", "Encumbrances of");
                text = text.replaceAll("(A1L1M1T1G1)", "Under charge of " + st);
            }
            else {
                text = text.replaceAll("(ALREADYMORTGAGE)", "");
                text = text.replaceAll("(ALMTGAD)", "");
                text = text.replaceAll("(ALMTGEX)", "");
                text = text.replaceAll("(ALMTGYN)", "No");
                text = text.replaceAll("(A1L1M1T1G1)", "");
            }
        }
        if (this.selectedBank.equals("UNION")) {
            if (this.alreadyMortgaged) {
                text = text.replace("No any encumbrance on this land", "");
                final String st = "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + ", I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " already encumbrance " + "on the said property . also search in the Sub registrars office at " + this.searchMaster.getSubRegistrar() + " Already Noted with " + "revenue authority mortgage registered in fovour of bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + " No any Break in the chain of title . Banks creation of mortgage over the property not vitiate.";
                text = text.replaceAll("(ALMTG)", st);
            }
            else {
                text = text.replaceAll("(ALMTG)", "NIL");
            }
        }
        if (this.selectedBank.equals("ICICI")) {
            if (this.alreadyMortgaged) {
                String st = "I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " Years, already BANKNAME Branch BRANCH " + "encumbrance on the said property , also search in the Sub registrars " + "office SUBREGISTRAR . charge already noted with revenue authority " + "mortgage deed registered in favor of bank of BANKNAME Branch BRANCH. " + "No any Break in the chain of title . Banks creation of mortgage over the " + "property not vitiate ";
                if (this.searchMaster.getMortgagedWith().equalsIgnoreCase("With Other Bank")) {
                    st += "after the non encumbrances of BANKNAME Branch BRANCH.";
                    if (text.contains("I am of the opinion the ")) {
                        System.out.println("yes");
                        text += "after the discharge of the encumbrances of BANKNAME Branch BRANCH.".replaceAll("(BRANCH)", this.searchMaster.getMortgagedBranch()).replaceAll("(BANKNAME)", this.searchMaster.getMortgagedBank());
                    }
                    text = text.replaceAll("(FITFOR)", "I hereby certify that above documents are fit for creation of security for ICICI Bank Ltd.");
                }
                else {
                    text = text.replace("1.7.", "");
                    text = text.replaceAll("(FITFOR)", "Note : I inform you that above documents are not fit for the creation of security for ICICI bank without NOC from " + this.searchMaster.getMortgagedBank() + " branch" + this.searchMaster.getMortgagedBranch());
                }
                st = st.replaceAll("(BRANCH)", this.searchMaster.getMortgagedBranch());
                st = st.replaceAll("(BANKNAME)", this.searchMaster.getMortgagedBank());
                st = st.replaceAll("(SUBREGISTRAR)", this.searchMaster.getSubRegistrar());
                text = text.replace("10.9", st);
            }
            else {
                text = text.replace("10.9", "");
                text = text.replace("1.7.", ".");
                text = text.replaceAll("(FITFOR)", "I hereby certify that above documents are fit for creation of security for ICICI Bank Ltd.");
            }
        }
        return text;
    }

    private void initializeVariables() {
        this.calculatePeriod();
        this.propertyAddr = "";
        this.totalShare = "";
        this.khasraNos = "";
        this.khataNos = "";
        this.jamabandiSmts = "";
        this.jamadts = "";
        this.girdawariSmts = "";
        this.girddts = "";
        this.tldates = "";
        this.villages = "";
        this.patwariAreas = "";
        this.patwariVillages = "";
        this.states = "";
        this.districts = "";
        this.tehsils = "";
        this.chains = "";
        this.lastSaleDeedDate = "";
        this.totalSize = "";
        this.totalDLC = 0;
        this.totalHect = 0.0;
        this.hectPercent = 0.0;
        this.appShareHect = 0.0;
        this.shareTotalBigha = 0;
        this.shareTotalBishwa = 0;
        this.totalBigha = 0;
        this.totalBishwa = 0;
        this.pnbTable1 = new HashMap<String, HashMap<String, ArrayList<String[]>>>();
        ArrayList<String[]> pnbSizeList = new ArrayList<String[]>();
        HashMap<String, ArrayList<String[]>> pnbKhataMap = new HashMap<String, ArrayList<String[]>>();
        this.calculatePeriod();
        this.heldBys = new String[] { "", "" };
        for (int k = 0; k < this.properties.size(); ++k) {
            final Property property = this.properties.get(k);
            if (property.getHeldBy().equals("Ancestral")) {
                final StringBuilder sb = new StringBuilder();
                final String[] heldBys = this.heldBys;
                final int n = 0;
                heldBys[n] = sb.append(heldBys[n]).append(property.getKhasraNo()).append(",").toString();
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                final String[] heldBys2 = this.heldBys;
                final int n2 = 1;
                heldBys2[n2] = sb2.append(heldBys2[n2]).append(property.getKhasraNo()).append(",").toString();
            }
            final String tpaddr = " Village:- " + property.getVillage() + ", Tehsil:" + property.getTehsil() + ", District:" + property.getDistrict() + ", State:" + property.getState();
            if (!this.propertyAddr.contains(tpaddr)) {
                this.propertyAddr = this.propertyAddr + "(" + (k + 1) + ")" + tpaddr + ",";
            }
            final String tkno = property.getKhasraNo();
            if (!this.khasraNos.contains(tkno)) {
                this.khasraNos = this.khasraNos + tkno + ",";
            }
            final String kno = property.getKhataNo();
            if (!this.khataNos.contains(kno)) {
                this.khataNos = this.khataNos + kno + ",";
            }
            String jbdi = property.getJamabandi();
            if (jbdi.length() > 11) {
                jbdi = jbdi.substring(11);
                if (!this.jamabandiSmts.contains(jbdi)) {
                    this.jamabandiSmts = this.jamabandiSmts + jbdi + ",";
                }
            }
            String jbdidt = property.getJamabandi();
            if (jbdidt.length() >= 10) {
                jbdidt = jbdidt.substring(0, 10);
                if (!this.jamadts.contains(jbdidt)) {
                    this.jamadts = this.jamadts + jbdidt + ",";
                }
            }
            String gird = property.getGirdawari();
            if (gird.length() > 11) {
                gird = gird.substring(11);
                if (!this.girdawariSmts.contains(gird)) {
                    this.girdawariSmts = this.girdawariSmts + gird + ",";
                }
            }
            String girddt = property.getGirdawari();
            if (girddt.length() >= 10) {
                girddt = girddt.substring(0, 10);
                if (!this.girddts.contains(girddt)) {
                    this.girddts = this.girddts + jbdidt + ",";
                }
            }
            final String vlg = property.getVillage();
            if (!this.villages.contains(vlg)) {
                this.villages = this.villages + vlg + ",";
            }
            final String dis = property.getDistrict();
            if (!this.districts.contains(dis)) {
                this.districts = this.districts + dis + ",";
            }
            final String st = property.getState();
            if (!this.states.contains(st)) {
                this.states = this.states + st + ",";
            }
            final String teh = property.getTehsil();
            if (!this.tehsils.contains(teh)) {
                this.tehsils = this.tehsils + teh + ",";
            }
            final String tld = property.getTldate();
            if (!this.tldates.contains(tld)) {
                this.tldates = this.tldates + tld + ",";
            }
            final String ptv = property.getPatwariVillage();
            if (!this.patwariVillages.contains(ptv)) {
                this.patwariVillages = this.patwariVillages + ptv + ",";
            }
            final String pta = property.getPatwariArea();
            if (!this.patwariAreas.contains(pta)) {
                this.patwariAreas = this.patwariAreas + pta + ",";
            }
            final float tb = new Float(property.getShareCalculated());
            this.totalDLC += (int)(tb * property.getDlc());
            pnbSizeList = new ArrayList<String[]>();
            final String pnbVillage = property.getVillage();
            pnbKhataMap = new HashMap<String, ArrayList<String[]>>();
            final String pnbKhata = property.getKhataNo();
            final String[] pnbSize = { property.getKhasraNo(), property.getSize() };
            if (this.pnbTable1.containsKey(pnbVillage)) {
                pnbKhataMap = this.pnbTable1.get(pnbVillage);
                if (pnbKhataMap.containsKey(pnbKhata)) {
                    pnbSizeList = pnbKhataMap.get(pnbKhata);
                }
            }
            pnbSizeList.add(pnbSize);
            pnbKhataMap.put(pnbKhata, pnbSizeList);
            this.pnbTable1.put(pnbVillage, pnbKhataMap);
            final String csh = this.df.format(property.getShareCalculated());
            final String[] bb = csh.split("\\.");
            float bis = 0.0f;
            if (bb.length == 2) {
                if (bb[1].length() == 1) {
                    final StringBuilder sb3 = new StringBuilder();
                    final String[] array = bb;
                    final int n3 = 1;
                    array[n3] = sb3.append(array[n3]).append("0").toString();
                }
                bis = Float.parseFloat(bb[1]);
            }
            else {
                bis = 0.0f;
            }
            this.shareTotalBigha += Integer.parseInt(bb[0]);
            bis /= 5.0f;
            bis = new Float(this.df4.format(bis));
            this.shareTotalBishwa += (int)bis;
            final String[] split;
            final String[] sizes = split = property.getSize().split(",");
            for (final String size : split) {
                final String[] bigbis = size.split("-");
                final Float bigha = new Float(bigbis[0]);
                final Float bishwah = new Float(bigbis[1]);
                if (bigha != null) {
                    this.totalBigha += (int)(Object)bigha.intValue();
                }
                if (bishwah != null) {
                    this.totalBishwa += (int)(Object)bishwah.intValue();
                }
            }
        }
        for (int i = 0; i < this.channelHistories.size(); ++i) {
            final ChannelHistory his = this.channelHistories.get(i);
            if (his.getNature().equalsIgnoreCase("Sale Deed")) {
                this.lastSaleDeedDate = his.getDeedDate();
            }
        }
        this.chains = this.txt_chain.getText().trim();
        if (this.chains.length() > 1) {
            this.chains = this.chains.substring(0, this.chains.length() - 1);
        }
        if (this.propertyAddr.length() > 1) {
            this.propertyAddr = this.propertyAddr.substring(0, this.propertyAddr.length() - 1);
        }
        if (this.khataNos.length() > 1) {
            this.khataNos = this.khataNos.substring(0, this.khataNos.length() - 1);
        }
        if (this.khasraNos.length() > 1) {
            this.khasraNos = this.khasraNos.substring(0, this.khasraNos.length() - 1);
        }
        if (this.villages.length() > 1) {
            this.villages = this.villages.substring(0, this.villages.length() - 1);
        }
        if (this.tehsils.length() > 1) {
            this.tehsils = this.tehsils.substring(0, this.tehsils.length() - 1);
        }
        if (this.jamabandiSmts.length() > 1) {
            this.jamabandiSmts = this.jamabandiSmts.substring(0, this.jamabandiSmts.length() - 1);
        }
        if (this.jamadts.length() > 1) {
            this.jamadts = this.jamadts.substring(0, this.jamadts.length() - 1);
        }
        this.heldByStr = "";
        if (this.heldBys[0].length() > 1) {
            this.heldBys[0] = this.heldBys[0].substring(0, this.heldBys[0].length() - 1);
            this.heldByStr = "Khasra No " + this.heldBys[0] + " Ancestral";
        }
        if (this.heldByStr.length() > 0) {
            this.heldByStr += ", ";
        }
        if (this.heldBys[1].length() > 1) {
            this.heldBys[1] = this.heldBys[1].substring(0, this.heldBys[1].length() - 1);
            this.heldByStr = this.heldByStr + "Khasra No " + this.heldBys[1] + " Self Acquired";
        }
        if (this.heldBys[0].length() > 1 && this.heldBys[1].length() == 0) {
            this.heldByStr = "Ancestral";
        }
        else if (this.heldBys[1].length() > 1 && this.heldBys[0].length() == 0) {
            this.heldByStr = "Self-Acquired";
        }
        final double temp = this.totalBishwa / 20.0f + this.totalBigha;
        this.totalHect = temp / 6.25;
        final double tempBig = this.shareTotalBishwa / 20.0f + this.shareTotalBigha;
        this.appShareHect = tempBig / 6.25;
        if (this.totalBishwa > 19) {
            do {
                ++this.totalBigha;
                this.totalBishwa -= 20;
            } while (this.totalBishwa > 19);
        }
        if (this.shareTotalBishwa > 19) {
            do {
                ++this.shareTotalBigha;
                this.shareTotalBishwa -= 20;
            } while (this.shareTotalBishwa > 19);
        }
        this.hectPercent = this.appShareHect / this.totalHect * 100.0;
        this.totalShare = this.shareTotalBigha + " Bigha " + this.shareTotalBishwa + " Bishwa";
        this.totalSize = this.totalBigha + " Bigha " + this.totalBishwa + " Bishwa";
        this.totalAcres = (this.shareTotalBigha * 20.0f + this.shareTotalBishwa) / 50.0f;
        System.out.println("App Share Hect : " + this.appShareHect);
        System.out.println("App % Hect : " + this.hectPercent);
        System.out.println("Total Hect : " + this.totalHect);
    }

    private void initializeVariablesAabadi() {
        this.calculatePeriod();
        final String villageAabadi = "";
        this.aabadiFirstIssuedBy = villageAabadi;
        this.aabadiFirstDate = villageAabadi;
        this.receiptAabadi = villageAabadi;
        this.conversionOrderIssuedByAabadi = villageAabadi;
        this.aabadiHoldBy = villageAabadi;
        this.aabadiDocsDate = villageAabadi;
        this.lastSaleDeedIssuedByAabadi = villageAabadi;
        this.lastSaleDeedDate = villageAabadi;
        this.fullDetailOfDocumentsAabadi = villageAabadi;
        this.conversionOrderDateAabadi = villageAabadi;
        this.availableDocsOriginalAabadi = villageAabadi;
        this.availableDocsAabadi = villageAabadi;
        this.chainAabadi = villageAabadi;
        this.dlcAabadi = villageAabadi;
        this.southAabadi = villageAabadi;
        this.northAabadi = villageAabadi;
        this.westAabadi = villageAabadi;
        this.eastAabadi = villageAabadi;
        this.sizeAabadi = villageAabadi;
        this.bookAabadi = villageAabadi;
        this.missalAabadi = villageAabadi;
        this.pattaAabadi = villageAabadi;
        this.khasraAabadi = villageAabadi;
        this.stateAabadi = villageAabadi;
        this.districtAabadi = villageAabadi;
        this.tehsilAabadi = villageAabadi;
        this.villageAabadi = villageAabadi;
        this.villageAabadi = this.aabadiProperty.getVillage();
        this.tehsilAabadi = this.aabadiProperty.getTehsil();
        this.districtAabadi = this.aabadiProperty.getDistrict();
        this.stateAabadi = this.aabadiProperty.getState();
        this.khasraAabadi = this.aabadiProperty.getKhasraNo();
        this.pattaAabadi = this.aabadiProperty.getPattaNo();
        this.missalAabadi = this.aabadiProperty.getMissalNo();
        this.bookAabadi = this.aabadiProperty.getBookNo();
        this.sizeAabadi = this.aabadiProperty.getSize();
        this.eastAabadi = this.aabadiProperty.getEast();
        this.westAabadi = this.aabadiProperty.getWest();
        this.northAabadi = this.aabadiProperty.getNorth();
        this.southAabadi = this.aabadiProperty.getSouth();
        this.dlcAabadi = this.aabadiProperty.getDlc();
        this.receiptAabadi = this.aabadiProperty.getReceiptNumber();
        this.chainAabadi = this.txt_chainAabadi.getText();
        for (final DocumentList dList : this.documentLists) {
            if (dList.getDocumentName().toLowerCase().startsWith("conversion order")) {
                this.conversionOrderDateAabadi = "Conversion Order on Date " + dList.getDate();
                this.conversionOrderIssuedByAabadi = dList.getIssuedBy();
            }
            if (dList.getDocumentName().toLowerCase().startsWith("sale deed")) {
                this.lastSaleDeedDate = dList.getDate();
                this.lastSaleDeedIssuedByAabadi = dList.getIssuedBy();
            }
            this.availableDocsAabadi = this.availableDocsAabadi + dList.getDocumentName() + ", ";
            String detail = "";
            final String dname = dList.getDocumentName();
            String dnumber = dList.getDocumentNumber();
            final String issuedBy = dList.getIssuedBy();
            final String issuedTo = dList.getIssuedTo();
            String samwat = dList.getSamwat();
            String ddate = dList.getDate();
            final String required = dList.getRequired();
            this.aabadiDocsDate = this.aabadiDocsDate + dname + " dated " + ddate + ",";
            if (this.aabadiHoldBy.length() == 0) {
                this.aabadiHoldBy = issuedBy;
                this.aabadiFirstDate = ddate;
                this.aabadiFirstIssuedBy = issuedBy;
            }
            this.availableDocsOriginalAabadi += (required.toLowerCase().contains("original") ? (dname + ",") : "");
            samwat = (samwat.trim().isEmpty() ? "" : (" Samwat " + samwat));
            ddate = (ddate.trim().isEmpty() ? "" : (" Dated " + ddate));
            dnumber = (dnumber.trim().isEmpty() ? "" : (" Document Number " + dnumber));
            detail = required.replace("Yes - ", "") + " " + dname + "" + samwat + " " + dList.getIssuedByCaption() + " " + issuedBy + " " + dList.getIssuedToCaption() + " " + issuedTo + "" + ddate + "" + dnumber;
            this.fullDetailOfDocumentsAabadi = this.fullDetailOfDocumentsAabadi + detail + "{$}";
        }
        if (this.lastSaleDeedDate.length() <= 1) {
            if (this.conversionOrderDateAabadi.length() > 1) {
                this.lastSaleDeedDate = this.conversionOrderDateAabadi;
                this.lastSaleDeedIssuedByAabadi = this.conversionOrderIssuedByAabadi;
            }
            else {
                this.lastSaleDeedDate = this.aabadiFirstDate;
                this.lastSaleDeedIssuedByAabadi = this.aabadiFirstIssuedBy;
            }
        }
        this.fullDetailOfDocumentsAabadi = this.fullDetailOfDocumentsAabadi.substring(0, this.fullDetailOfDocumentsAabadi.length() - 4);
    }

    private String textReplacerAabadi(String text) {
        if (text.contains("ABDUCEN")) {
            String st = "";
            if (this.conversionOrderDateAabadi.length() > 1) {
                st = "That Shr. NAME FH FATHERHUSBAND by cast CAST Residence at ADDRESS after conversion order of residential land in of Khasra No. KHNOS  With Sub Registrar \u2013 SUBREGISTRAR  District DISTRICT became the absolute owner of the aforesaid conversion land measuring  ABDSZ";
            }
            else {
                st = "That Shr. NAME FH FATHERHUSBAND by cast CAST Residence at ADDRESS after execution & registration of  will deed of residential land in of Patta No. PTTNOS  With Sub Registrar \u2013 SUBREGISTRAR  District DISTRICT became the absolute owner of the aforesaid Plot measuring  ABDSZ.";
            }
            text = text.replace("ABDUCEN", st);
        }
        text = text.replaceAll("(ADVOCATENAME)", this.searchMaster.getAdvocate());
        String mno;
        if (this.selectedAdvocate.equalsIgnoreCase("Chandan Singh Bhati")) {
            mno = "94144-40557";
        }
        else {
            mno = "94144-94726";
        }
        if (this.searchMaster.getBank().equals("ICICI")) {
            text = text.replace("10.9", "");
            text = text.replace("1.7.", ".");
            text = text.replaceAll("(FITFOR)", "I hereby certify that above documents are fit for creation of security for ICICI Bank Ltd.");
        }
        text = text.replace("MNO", mno);
        text = text.replaceAll("(DATE)", this.searchMaster.getDateOfSearch());
        text = text.replaceAll("(BRANCH)", this.searchMaster.getBranch());
        text = text.replaceAll("(BANK)", this.searchMaster.getBank());
        text = text.replaceAll("(BORROWER/GAURANTOR)", "BORROWER");
        text = text.replaceAll("(SNO)", "" + this.searchMaster.getSno());
        text = text.replaceAll("(NAME)", this.applicantInfo.getName());
        text = text.replaceAll("(FATHERHUSBAND)", this.applicantInfo.getFhName());
        text = text.replaceAll("(FH)", this.applicantInfo.getFh());
        text = text.replaceAll("(CAST)", this.applicantInfo.getSirName());
        text = text.replaceAll("(ADDRESS)", this.applicantInfo.getAddress());
        if (!this.searchMaster.getBank().equals("ICICI")) {
            text = text.replaceAll("(REFNO)", this.searchMaster.getRefNo() + "_Bank:" + this.searchMaster.getBank());
        }
        else {
            text = text.replaceAll("(REFNO)", this.searchMaster.getRefNo());
        }
        text = text.replaceAll("(TSRYEAR)", this.tsrYear + "");
        text = text.replaceAll("(TSRPERIOD)", this.tsrPeriod + "");
        text = text.replaceAll("(SUBREGISTRAR)", this.searchMaster.getSubRegistrar());
        text = text.replaceAll("(LANDTYPE)", "Residential");
        text = text.replaceAll("(VLG)", this.aabadiProperty.getVillage());
        text = text.replaceAll("(TSL)", this.aabadiProperty.getTehsil());
        text = text.replaceAll("(TEHSILS)", this.aabadiProperty.getTehsil());
        text = text.replaceAll("(ABDSTAT)", this.aabadiProperty.getState());
        text = text.replaceAll("(A1B1D1D1S1T)", this.aabadiProperty.getDistrict());
        text = text.replaceAll("(DISTRICT)", this.aabadiProperty.getDistrict());
        String propertyInfo = "";
        if (this.aabadiProperty.getKhasraNo().isEmpty()) {
            propertyInfo = (this.aabadiProperty.getPattaNo().isEmpty() ? "" : ("Patta No : " + this.aabadiProperty.getPattaNo()));
            propertyInfo += (this.aabadiProperty.getMissalNo().isEmpty() ? "" : (" Missal No : " + this.aabadiProperty.getMissalNo()));
            propertyInfo += (this.aabadiProperty.getBookNo().isEmpty() ? "" : (" Book No : " + this.aabadiProperty.getBookNo()));
        }
        else {
            propertyInfo = (this.aabadiProperty.getKhasraNo().isEmpty() ? "" : ("Khasra No : " + this.aabadiProperty.getKhasraNo()));
        }
        text = text.replaceAll("(ABDSBIPROINFO)", propertyInfo);
        text = text.replaceAll("(KHNOS)", this.aabadiProperty.getKhasraNo());
        text = text.replaceAll("(KHNO)", this.aabadiProperty.getKhasraNo());
        text = text.replaceAll("(PTTNOS)", this.aabadiProperty.getPattaNo());
        text = text.replaceAll("(PTTNO)", this.aabadiProperty.getPattaNo());
        text = text.replaceAll("(MSLNOS)", this.aabadiProperty.getMissalNo());
        text = text.replaceAll("(MSLNO)", this.aabadiProperty.getMissalNo());
        text = text.replaceAll("(BKNOS)", this.aabadiProperty.getBookNo());
        text = text.replaceAll("(BKNO)", this.aabadiProperty.getBookNo());
        text = text.replaceAll("(ABDSZ)", this.aabadiProperty.getSize());
        text = text.replaceAll("(ABDEAST)", this.aabadiProperty.getEast());
        text = text.replaceAll("(ABDWEST)", this.aabadiProperty.getWest());
        text = text.replaceAll("(ABDNORTH)", this.aabadiProperty.getNorth());
        text = text.replaceAll("(ABDSOUTH)", this.aabadiProperty.getSouth());
        text = text.replaceAll("(ABDRCNO)", this.aabadiProperty.getReceiptNumber());
        text = text.replaceAll("(ABDLC)", this.aabadiProperty.getDlc());
        text = text.replaceAll("(CONORDT)", this.conversionOrderDateAabadi);
        text = text.replaceAll("(ABDOCDTS)", this.aabadiDocsDate);
        text = text.replaceAll("(ABDHLD)", this.aabadiHoldBy);
        text = text.replaceAll("(ABDCHN)", this.chainAabadi);
        text = text.replaceAll("(ABDOCLST)", this.availableDocsAabadi);
        text = text.replaceAll("(ABDORDOCLST)", this.availableDocsOriginalAabadi);
        text = text.replaceAll("(ABDFDOCLST)", this.fullDetailOfDocumentsAabadi);
        text = text.replaceAll("(LSDD)", this.lastSaleDeedDate);
        text = text.replaceAll("(ABDLSDISDBY)", this.lastSaleDeedIssuedByAabadi);
        if (text.contains("A2B2D2A2L2M2T2G2")) {
            System.out.println(text);
        }
        if (this.selectedBank.equals("UCO")) {
            if (this.alreadyMortgaged) {
                final String st2 = "other then " + this.searchMaster.getMortgagedBank() + " bank " + this.searchMaster.getMortgagedBranch() + "";
                final String st3 = "This property duly equitable mortgaged with " + this.searchMaster.getMortgagedBank() + " bank " + this.searchMaster.getMortgagedBranch() + " and said property charge of other then this bank absolutely clear free and marketable it is fit for equitable mortgage";
                text = text.replaceAll("(A1B1D1A1L1M1T1G1)", st2);
                text = text.replaceAll("(A2B2D2A2L2M2T2G2)", st3);
            }
            else {
                text = text.replaceAll("(A1B1D1A1L1M1T1G1)", "");
                text = text.replaceAll("(A2B2D2A2L2M2T2G2)", "and said property absolutely clear free and marketable it is fit for equitable mortgage");
            }
        }
        if (this.selectedBank.equals("BOB")) {
            if (this.alreadyMortgaged) {
                final String st4 = "Encumbrance/charge on this land with Bank " + this.searchMaster.getMortgagedBank() + ", Branch " + this.searchMaster.getMortgagedBranch();
                text = text.replaceAll("(ALMTG)", st4);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("PNB") || this.selectedBank.equals("RMGB")) {
            if (this.alreadyMortgaged) {
                text = text.replace("No any encumbrance /charge on this land", "Encumbrance /charge on this land");
                final String st4 = "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + ", I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " already encumbrance " + "on the said property . also search in the Sub registrars office at " + this.searchMaster.getSubRegistrar() + " Already Noted with " + "revenue authority mortgage registered in fovour of bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + " No any Break in the chain of title . Banks creation of mortgage over the property not vitiate.";
                text = text.replaceAll("(ALMTG)", st4);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("OBC")) {
            if (this.alreadyMortgaged) {
                text = text.replaceAll("(ALREADYMORTGAGE)", "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch());
            }
            else {
                text = text.replaceAll("(ALREADYMORTGAGE)", "No any encumbrance/charge on this land");
            }
        }
        if (this.selectedBank.equals("SBI")) {
            if (this.alreadyMortgaged) {
                final String st4 = "Mortgaged with Bank " + this.searchMaster.getMortgagedBank() + ", Branch " + this.searchMaster.getMortgagedBranch();
                text = text.replaceAll("(ALMTG)", st4);
            }
            else {
                text = text.replaceAll("(ALMTG)", "");
            }
        }
        if (this.selectedBank.equals("AXIS")) {
            if (this.alreadyMortgaged) {
                final String st4 = this.searchMaster.getMortgagedBank() + " Bank, " + this.searchMaster.getMortgagedBranch() + " Branch";
                text = text.replaceAll("(ALREADYMORTGAGE)", st4);
                text = text.replaceAll("(ALMTGAD)", "after discharge of");
                text = text.replaceAll("(ALMTGEX)", "except the");
                text = text.replaceAll("(ALMTGYN)", "Encumbrances of");
            }
            else {
                text = text.replaceAll("(ALREADYMORTGAGE)", "");
                text = text.replaceAll("(ALMTGAD)", "");
                text = text.replaceAll("(ALMTGEX)", "");
                text = text.replaceAll("(ALMTGYN)", "No");
            }
        }
        if (this.selectedBank.equals("UNION")) {
            if (this.alreadyMortgaged) {
                text = text.replace("No any encumbrance on this land", "");
                final String st4 = "Encumbrance/charge on this land bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + ", I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " already encumbrance " + "on the said property . also search in the Sub registrars office at " + this.searchMaster.getSubRegistrar() + " Already Noted with " + "revenue authority mortgage registered in fovour of bank " + this.searchMaster.getMortgagedBank() + " Branch " + this.searchMaster.getMortgagedBranch() + " No any Break in the chain of title . Banks creation of mortgage over the property not vitiate.";
                text = text.replaceAll("(ALMTG)", st4);
            }
            else {
                text = text.replaceAll("(ALMTG)", "NIL");
            }
        }
        if (this.selectedBank.equals("ICICI")) {
            if (this.alreadyMortgaged) {
                String st4 = "I have certified by search in the records and investigation the concern documents Past " + this.tsrYear + " Years, already BANKNAME Branch BRANCH " + "encumbrance on the said property , also search in the Sub registrars " + "office SUBREGISTRAR . charge already noted with revenue authority " + "mortgage deed registered in favor of bank of BANKNAME Branch BRANCH. " + "No any Break in the chain of title . Banks creation of mortgage over the " + "property not vitiate ";
                if (this.searchMaster.getMortgagedWith().equalsIgnoreCase("With Other Bank")) {
                    st4 += "after the non encumbrances of BANKNAME Branch BRANCH.";
                    if (text.contains("I am of the opinion the ")) {
                        System.out.println("yes");
                        text += "after the discharge of the encumbrances of BANKNAME Branch BRANCH.".replaceAll("(BRANCH)", this.searchMaster.getMortgagedBranch()).replaceAll("(BANKNAME)", this.searchMaster.getMortgagedBank());
                    }
                    text = text.replaceAll("(FITFOR)", "I hereby certify that above documents are fit for creation of security for ICICI Bank Ltd.");
                }
                else {
                    text = text.replace("1.7.", "");
                    text = text.replaceAll("(FITFOR)", "Note : I inform you that above documents are not fit for the creation of security for ICICI bank without NOC from " + this.searchMaster.getMortgagedBank() + " branch" + this.searchMaster.getMortgagedBranch());
                }
                st4 = st4.replaceAll("(BRANCH)", this.searchMaster.getMortgagedBranch());
                st4 = st4.replaceAll("(BANKNAME)", this.searchMaster.getMortgagedBank());
                st4 = st4.replaceAll("(SUBREGISTRAR)", this.searchMaster.getSubRegistrar());
                text = text.replace("10.9", st4);
            }
            else {
                text = text.replace("10.9", "");
                text = text.replace("1.7.", ".");
                text = text.replaceAll("(FITFOR)", "I hereby certify that above documents are fit for creation of security for ICICI Bank Ltd.");
            }
        }
        return text;
    }
}
