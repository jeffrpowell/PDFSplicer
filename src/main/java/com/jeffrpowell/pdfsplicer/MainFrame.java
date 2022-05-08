package com.jeffrpowell.pdfsplicer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class MainFrame extends javax.swing.JFrame
{

	private final JFileChooser fileChooser;
	private final Set<Path> joinFilesSet;
	private final List<Path> joinFiles;
	private Path splitFile;
	private Path joinFile;
	private Path extractFile;
	
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame()
	{
		this.fileChooser = new JFileChooser(Paths.get("\\").toFile());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(new PdfFilter());
		this.joinFilesSet = new HashSet<>();
		this.joinFiles = new ArrayList<>();
		initComponents();
	}

	private void updateJoinFilesList()
	{
		DefaultListModel<String> listModel = new DefaultListModel();
		joinFiles.stream().map(Path::toString).forEach(listModel::addElement);
		this.listJoinFiles.setModel(listModel);
		btnJoin.setEnabled(!joinFiles.isEmpty() && joinFile != null);
	}

	private void mergePaths(File[] files)
	{
		for (File file : files)
		{
			if (joinFilesSet.add(file.toPath())) {
				joinFiles.add(file.toPath());
			}
		}
	}

	private void setSelectionButtonsEnabled(boolean enabled)
	{
		btnJoinSelection.setEnabled(enabled);
		btnJoinRemoval.setEnabled(enabled);
		btnSpliceSelection.setEnabled(enabled);
        btnExtractSelection.setEnabled(enabled);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnSpliceSelection = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        lblSpliceLocation = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        jPanel7 = new javax.swing.JPanel();
        btnSplice = new javax.swing.JButton();
        btnSpliceBooklet = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jSeparator1 = new javax.swing.JSeparator();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnJoinSelection = new javax.swing.JButton();
        btnJoinRemoval = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jScrollPane1 = new javax.swing.JScrollPane();
        listJoinFiles = new javax.swing.JList<>();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jPanel9 = new javax.swing.JPanel();
        btnJoinPathSelection = new javax.swing.JButton();
        lblJoinLocation = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jPanel8 = new javax.swing.JPanel();
        btnJoin = new javax.swing.JButton();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jSeparator2 = new javax.swing.JSeparator();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnExtractSelection = new javax.swing.JButton();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        lblExtractLocation = new javax.swing.JLabel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        jPanel13 = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        jLabel4 = new javax.swing.JLabel();
        txtExtractFromPage = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtExtractToPage = new javax.swing.JTextField();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        jPanel14 = new javax.swing.JPanel();
        btnExtract = new javax.swing.JButton();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(filler9);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Split File Apart");
        jPanel5.add(jLabel2);

        jPanel2.add(jPanel5);

        btnSpliceSelection.setText("Select File to Split Apart");
        btnSpliceSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpliceSelectionActionPerformed(evt);
            }
        });
        jPanel6.add(btnSpliceSelection);

        jPanel2.add(jPanel6);
        jPanel2.add(filler7);

        lblSpliceLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblSpliceLocation);
        jPanel2.add(filler8);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        btnSplice.setText("Split File");
        btnSplice.setEnabled(false);
        btnSplice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpliceActionPerformed(evt);
            }
        });
        jPanel7.add(btnSplice);

        btnSpliceBooklet.setText("Split Booklet File");
        btnSpliceBooklet.setToolTipText("If your PDF pages consist of two pages split with a vertical line in the center, choose this button.");
        btnSpliceBooklet.setEnabled(false);
        btnSpliceBooklet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpliceBookletActionPerformed(evt);
            }
        });
        jPanel7.add(btnSpliceBooklet);

        jPanel2.add(jPanel7);

        getContentPane().add(jPanel2);
        getContentPane().add(filler10);
        getContentPane().add(jSeparator1);
        getContentPane().add(filler11);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Join Files Together");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.X_AXIS));

        btnJoinSelection.setText("Add Files to Join");
        btnJoinSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinSelectionActionPerformed(evt);
            }
        });
        jPanel4.add(btnJoinSelection);

        btnJoinRemoval.setText("Remove Selected Files");
        btnJoinRemoval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinRemovalActionPerformed(evt);
            }
        });
        jPanel4.add(btnJoinRemoval);

        jPanel1.add(jPanel4);
        jPanel1.add(filler1);

        listJoinFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listJoinFiles);

        jPanel1.add(jScrollPane1);
        jPanel1.add(filler2);

        jPanel9.setLayout(new java.awt.BorderLayout());

        btnJoinPathSelection.setText("Name of New File");
        btnJoinPathSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinPathSelectionActionPerformed(evt);
            }
        });
        jPanel9.add(btnJoinPathSelection, java.awt.BorderLayout.WEST);

        lblJoinLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(lblJoinLocation, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel9);
        jPanel1.add(filler3);

        jPanel8.setLayout(new java.awt.BorderLayout());

        btnJoin.setText("Join Files");
        btnJoin.setEnabled(false);
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });
        jPanel8.add(btnJoin, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel8);

        getContentPane().add(jPanel1);
        getContentPane().add(filler12);
        getContentPane().add(jSeparator2);
        getContentPane().add(filler15);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Extract Partial PDF");
        jPanel11.add(jLabel3);

        jPanel10.add(jPanel11);

        btnExtractSelection.setText("Select File to Extract From");
        btnExtractSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractSelectionActionPerformed(evt);
            }
        });
        jPanel12.add(btnExtractSelection);

        jPanel10.add(jPanel12);
        jPanel10.add(filler13);

        lblExtractLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(lblExtractLocation);
        jPanel10.add(filler14);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.X_AXIS));
        jPanel13.add(filler4);

        jLabel4.setText("From page");
        jPanel13.add(jLabel4);
        jPanel13.add(txtExtractFromPage);

        jLabel5.setText(" to page ");
        jPanel13.add(jLabel5);
        jPanel13.add(txtExtractToPage);
        jPanel13.add(filler5);

        jPanel10.add(jPanel13);
        jPanel10.add(filler17);

        jPanel14.setLayout(new java.awt.BorderLayout());

        btnExtract.setText("Extract Partial PDF");
        btnExtract.setEnabled(false);
        btnExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractActionPerformed(evt);
            }
        });
        jPanel14.add(btnExtract, java.awt.BorderLayout.SOUTH);

        jPanel10.add(jPanel14);

        getContentPane().add(jPanel10);
        getContentPane().add(filler16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJoinSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinSelectionActionPerformed
		fileChooser.setMultiSelectionEnabled(true);
		int result = fileChooser.showDialog(this, "Select");
		if (result == JFileChooser.APPROVE_OPTION)
		{
			mergePaths(fileChooser.getSelectedFiles());
			updateJoinFilesList();
		}
    }//GEN-LAST:event_btnJoinSelectionActionPerformed

    private void btnSpliceSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpliceSelectionActionPerformed
		fileChooser.setMultiSelectionEnabled(false);
		int result = fileChooser.showDialog(this, "Select");
		if (result == JFileChooser.APPROVE_OPTION)
		{
			splitFile = fileChooser.getSelectedFile().toPath();
			lblSpliceLocation.setText(splitFile.toString());
			btnSplice.setEnabled(true);
            btnSpliceBooklet.setEnabled(true);
		}
    }//GEN-LAST:event_btnSpliceSelectionActionPerformed

    private void btnJoinRemovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinRemovalActionPerformed
		List<String> joinFilesToRemove = listJoinFiles.getSelectedValuesList();
		if (joinFilesToRemove != null && !joinFilesToRemove.isEmpty())
		{
			joinFilesSet.removeAll(joinFilesToRemove.stream().map(Paths::get).collect(Collectors.toList()));
			joinFiles.removeAll(joinFilesToRemove.stream().map(Paths::get).collect(Collectors.toList()));
			updateJoinFilesList();
		}
    }//GEN-LAST:event_btnJoinRemovalActionPerformed

    private void btnSpliceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSpliceActionPerformed
    {//GEN-HEADEREND:event_btnSpliceActionPerformed
		Splicer splitter = new Splicer(splitFile);
		setSelectionButtonsEnabled(false);
		btnSplice.setEnabled(false);
        btnSpliceBooklet.setEnabled(false);
		splitter.execute();
		try
		{
			splitter.get();
		} catch (InterruptedException | ExecutionException ex)
		{
            System.err.println(ex);
		}
		finally {
			splitFile = null;
			lblSpliceLocation.setText("");
			setSelectionButtonsEnabled(true);
		}
    }//GEN-LAST:event_btnSpliceActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnJoinActionPerformed
    {//GEN-HEADEREND:event_btnJoinActionPerformed
		Joiner joiner = new Joiner(joinFiles, joinFile);
		setSelectionButtonsEnabled(false);
		btnJoin.setEnabled(false);
		joiner.execute();
		try
		{
			joiner.get();
		} catch (InterruptedException | ExecutionException ex)
		{
            System.err.println(ex);
		}
		finally {
			joinFile = null;
			joinFiles.clear();
			joinFilesSet.clear();
			lblJoinLocation.setText("");
			updateJoinFilesList();
			setSelectionButtonsEnabled(true);
		}
    }//GEN-LAST:event_btnJoinActionPerformed

    private void btnJoinPathSelectionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnJoinPathSelectionActionPerformed
    {//GEN-HEADEREND:event_btnJoinPathSelectionActionPerformed
        fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setSelectedFile(Paths.get("").toFile());
		int result = fileChooser.showDialog(this, "Select");
		if (result == JFileChooser.APPROVE_OPTION)
		{
			joinFile = fileChooser.getSelectedFile().toPath();
			if (!joinFile.endsWith(".pdf")) {
				joinFile = joinFile.resolveSibling(joinFile.getFileName().toString() + ".pdf");
			}
			lblJoinLocation.setText(joinFile.toString());
			btnJoin.setEnabled(!joinFiles.isEmpty());
		}
    }//GEN-LAST:event_btnJoinPathSelectionActionPerformed

    private void btnSpliceBookletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpliceBookletActionPerformed
        BookletSplicer splitter = new BookletSplicer(splitFile);
		setSelectionButtonsEnabled(false);
		btnSplice.setEnabled(false);
        btnSpliceBooklet.setEnabled(false);
		splitter.execute();
		try
		{
			splitter.get();
		} catch (InterruptedException | ExecutionException ex)
		{
            System.err.println(ex);
		}
		finally {
			splitFile = null;
			lblSpliceLocation.setText("");
			setSelectionButtonsEnabled(true);
		}
    }//GEN-LAST:event_btnSpliceBookletActionPerformed

    private void btnExtractSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractSelectionActionPerformed
        fileChooser.setMultiSelectionEnabled(false);
		int result = fileChooser.showDialog(this, "Select");
		if (result == JFileChooser.APPROVE_OPTION)
		{
			extractFile = fileChooser.getSelectedFile().toPath();
			lblExtractLocation.setText(extractFile.toString());
            txtExtractFromPage.setText("1");
            int pages = Extractor.getPages(extractFile);
            if (pages == -1) {
                pages = 1;
            }
            txtExtractToPage.setText(Integer.toString(pages));
			btnExtract.setEnabled(true);
		}
    }//GEN-LAST:event_btnExtractSelectionActionPerformed

    private void btnExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractActionPerformed
		Extractor extractor = new Extractor(extractFile, Integer.parseInt(txtExtractFromPage.getText()), Integer.parseInt(txtExtractToPage.getText()));
		setSelectionButtonsEnabled(false);
		btnExtract.setEnabled(false);
        extractor.execute();
		try
		{
			extractor.get();
		} catch (InterruptedException | ExecutionException ex)
		{
            System.err.println(ex);
		}
		finally {
            btnExtract.setEnabled(true);
			setSelectionButtonsEnabled(true);
		}
    }//GEN-LAST:event_btnExtractActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MainFrame().setVisible(true);
			}
		});
	}
	
	private static class PdfFilter extends FileFilter {

		@Override
		public boolean accept(File f)
		{
			return f.isDirectory() || f.getName().endsWith(".pdf");
		}

		@Override
		public String getDescription()
		{
			return "PDF Files";
		}
		
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExtract;
    private javax.swing.JButton btnExtractSelection;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnJoinPathSelection;
    private javax.swing.JButton btnJoinRemoval;
    private javax.swing.JButton btnJoinSelection;
    private javax.swing.JButton btnSplice;
    private javax.swing.JButton btnSpliceBooklet;
    private javax.swing.JButton btnSpliceSelection;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lblExtractLocation;
    public javax.swing.JLabel lblJoinLocation;
    public javax.swing.JLabel lblSpliceLocation;
    public javax.swing.JList<String> listJoinFiles;
    public javax.swing.JTextField txtExtractFromPage;
    public javax.swing.JTextField txtExtractToPage;
    // End of variables declaration//GEN-END:variables

}
