//
// Decompiled by Procyon v0.5.36
//

package advocatehelperv1;

import java.awt.event.*;
import java.util.Iterator;
import java.util.ArrayList;
import dbhelper.SearchResult;

import javax.swing.table.TableModel;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.Font;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import dbhelper.DBHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class PanelReport extends JPanel
{
    DefaultTableModel model;
    DBHandler dbHandler;
    private JButton btn_printReport;
    private JButton btn_search;
    private JComboBox<String> combo_advocate;
    private JComboBox<String> combo_bank;
    private JComboBox<String> combo_branch;
    private JLabel jLabel1;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable tab_result;
    private JTextField txt_date;
    private JTextField txt_khasra;
    private JTextField txt_name;
    private JTextField txt_refNo;
    private JTextField txt_village;

    public PanelReport() {
        this.initComponents();
        this.model = (DefaultTableModel)this.tab_result.getModel();
        this.dbHandler = DBHandler.getInstance();
        this.btn_printReport.setVisible(false);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.combo_advocate = new JComboBox<String>();
        this.jLabel2 = new JLabel();
        this.combo_bank = new JComboBox<String>();
        this.combo_branch = new JComboBox<String>();
        this.txt_refNo = new JTextField();
        this.jLabel34 = new JLabel();
        this.jLabel9 = new JLabel();
        this.txt_name = new JTextField();
        this.jLabel33 = new JLabel();
        this.txt_khasra = new JTextField();
        this.jLabel16 = new JLabel();
        this.txt_village = new JTextField();
        this.btn_search = new JButton();
        this.txt_date = new JTextField();
        this.jLabel3 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tab_result = new JTable();
        this.jPanel3 = new JPanel();
        this.btn_printReport = new JButton();
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Advocate");
        this.combo_advocate.setModel(new DefaultComboBoxModel<String>(new String[] { "Any", "Chandan Singh Bhati", "Parvat Singh Bhati" }));
        this.jLabel2.setText("Bank");
        this.combo_bank.setModel(new DefaultComboBoxModel<String>(new String[] { "Any", "AXIS", "AUFINANCE", "BOB", "BOI", "HDFC", "INDUSIND", "ICICI", "OBC", "PNB", "SBI", "RMGB", "UCO", "UNION","YES" }));
        this.combo_bank.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PanelReport.this.combo_bankActionPerformed(evt);
            }
        });
        this.combo_branch.setModel(new DefaultComboBoxModel<String>(new String[] { "Any", "Osian", "Mathaniya", "Tinwari", "Jodhpur" }));
        this.combo_branch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PanelReport.this.combo_branchActionPerformed(evt);
            }
        });
        this.jLabel34.setHorizontalAlignment(0);
        this.jLabel34.setText("APS ID");
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("Name");
        this.jLabel33.setText("Khasra No");
        this.jLabel16.setHorizontalAlignment(0);
        this.jLabel16.setText("Village");
        this.txt_village.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                PanelReport.this.txt_villageFocusLost(evt);
            }
        });
        this.btn_search.setFont(new Font("Tahoma", 1, 12));
        this.btn_search.setText("Search");
        this.btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PanelReport.this.btn_searchActionPerformed(evt);
            }
        });
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Date");
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel9, -1, -1, 32767).addComponent(this.jLabel1, -1, 66, 32767)).addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txt_name).addComponent(this.combo_advocate, 0, 135, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel2, -1, -1, 32767).addComponent(this.jLabel33, -1, 76, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.combo_bank, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.combo_branch, -2, -1, -2)).addComponent(this.txt_khasra)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel34, -1, 61, 32767).addComponent(this.jLabel16, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_refNo, -1, 118, 32767).addComponent(this.txt_village)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btn_search, -2, 140, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_date, -2, 84, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.combo_advocate, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.combo_bank, -2, -1, -2).addComponent(this.combo_branch).addComponent(this.jLabel34).addComponent(this.txt_refNo, -2, -1, -2).addComponent(this.txt_date, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.txt_name, -2, -1, -2).addComponent(this.jLabel33).addComponent(this.txt_khasra, -2, -1, -2).addComponent(this.jLabel16).addComponent(this.txt_village, -2, -1, -2)).addComponent(this.btn_search, -2, 0, 32767)).addGap(16, 16, 16)));
        this.tab_result.setModel(new DefaultTableModel(new Object[0][], new String[]{"SNO", "RefNo", "Advocate", "Bank", "Branch", "Date", "Name", "Khasra", "Village", "Type"}) {
            Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tab_result.setColumnSelectionAllowed(true);
        this.tab_result.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane1.setViewportView(this.tab_result);
        this.tab_result.getColumnModel().getSelectionModel().setSelectionMode(0);
        final GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, -1, -2).addGap(0, 0, 32767)));
        this.btn_printReport.setText("Print");
        final GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.btn_printReport).addGap(0, 0, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 29, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.btn_printReport).addGap(0, 0, 32767))));
        final GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2)));
    }

    private void combo_bankActionPerformed(final ActionEvent evt) {
    }

    private void combo_branchActionPerformed(final ActionEvent evt) {
    }

    private void txt_villageFocusLost(final FocusEvent evt) {
    }

    private void btn_searchActionPerformed(final ActionEvent evt) {
        String adv = this.combo_advocate.getSelectedItem().toString().toLowerCase();
        String bank = this.combo_bank.getSelectedItem().toString().toLowerCase();
        String branch = this.combo_branch.getSelectedItem().toString().toLowerCase();
        final String date = this.txt_date.getText().trim().toLowerCase();
        final String name = this.txt_name.getText().trim().toLowerCase();
        final String refno = this.txt_refNo.getText().trim().toLowerCase();
        final String village = this.txt_village.getText().trim().toLowerCase();
        final String khasra = this.txt_khasra.getText().trim().toLowerCase();
        final SearchResult sr = new SearchResult();
        if (adv.equalsIgnoreCase("Any")) {
            adv = "";
        }
        if (bank.equalsIgnoreCase("Any")) {
            bank = "";
        }
        if (branch.equalsIgnoreCase("Any")) {
            branch = "";
        }
        sr.setKhasraNo(khasra);
        sr.setAdvocate(adv);
        sr.setBank(bank);
        sr.setBranch(branch);
        sr.setDateOfSearch(date);
        sr.setName(name);
        sr.setVillage(village);
        sr.setRefNo(refno);
        System.out.println("Name:" + sr.getName());
        System.out.println("Advocate:" + sr.getAdvocate());
        System.out.println("Bank:" + sr.getBank());
        System.out.println("Branch:" + sr.getBranch());
        System.out.println("Date:" + sr.getDateOfSearch());
        System.out.println("Khasra:" + sr.getKhasraNo());
        System.out.println("Refno:" + sr.getRefNo());
        System.out.println("Village:" + sr.getVillage());
        this.model.setRowCount(0);
        final ArrayList<SearchResult> searchRecords = (ArrayList<SearchResult>)this.dbHandler.searchRecords(sr);
        for (final SearchResult searchRecord : searchRecords) {
            final String sn = searchRecord.getSno() + "";
            if (sn.startsWith("-")) {
                continue;
            }
            final String[] data = { sn, searchRecord.getRefNo(), searchRecord.getAdvocate(), searchRecord.getBank(), searchRecord.getBranch(), searchRecord.getDateOfSearch(), searchRecord.getName(), searchRecord.getKhasraNo(), searchRecord.getVillage(), searchRecord.getSearchCategory() };
            this.model.addRow(data);
        }
    }
}
