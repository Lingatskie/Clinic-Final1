/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.clnc;


/**
 *
 * @author Ella Marie
 */
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;


public class School extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    

    /**
     * Creates new form School
     */
    public School() {
        initComponents();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
        public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            handleTableSelection();
        }
    }
});
        initializeTableModel();
        
    }
    
     private void initializeTableModel() {
         
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Last name", "First name", "Age","Gender", "Department"," Course", "Year level", "Date", "Chief Compliant"}
       );
        
        jTable1.setModel(tableModel);
        jTable1.setModel(tableModel);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow selecting only one row at a time
    jTable1.setDefaultEditor(Object.class, null); // Make the table non-editable

    // Customize the row selection appearance
    jTable1.setSelectionBackground(Color.YELLOW);
    jTable1.setSelectionForeground(Color.BLACK);
    jTable1.getTableHeader().setReorderingAllowed(false);

    // Customize the row selection appearance
    jTable1.setSelectionBackground(Color.YELLOW);
    jTable1.setSelectionForeground(Color.BLACK);

    // Add a mouse listener to handle row selection
    jTable1.addMouseListener(new MouseAdapter() {
        // Existing code...
    });

    // Add a mouse listener to handle row selection
    jTable1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                // Row is selected, you can perform additional actions here if needed
                System.out.println("Selected Row: " + selectedRow);
                handleTableSelection(); // Assuming you have a method to handle row selection
            }
        }
    });
        
    }
    
    private void saveDataToFile(String data) {
        try {
            Path filePath = Path.of("clinic_records.txt");
            Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE, 
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void highlightEmptyFields() {
    // Get text from text fields
    String firstName = Fname.getText();
    String lastName = Lname.getText();
    String age = Age.getText();
    String dept = department.getText();
    String course = Course.getText();
    String yearLevel = YL.getText();
    String date = Date.getText();
    String comply = Chief.getText();

    // Check and highlight empty fields with red border
    if (firstName.isEmpty()) {
        Fname.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Fname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    if (lastName.isEmpty()) {
        Lname.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Lname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    if (course.isEmpty()) {
        Course.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Course.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    if (dept.isEmpty()) {
        department.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        department.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    if (age.isEmpty()) {
        Age.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Age.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    if (yearLevel.isEmpty()) {
       YL.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        YL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    if (date.isEmpty()) {
        Date.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Date.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    if (comply.isEmpty()) {
        Chief.setBorder(BorderFactory.createLineBorder(Color.RED));
    } else {
        Chief.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
    private String autoCorrect(String input) {
    if (input == null || input.isEmpty()) {
        return input;  // Return the input if it's null or empty
    }
    

    StringBuilder result = new StringBuilder();

    // Split the input into words and capitalize the first letter of each word
    String[] words = input.trim().split("\\s+");
    for (String word : words) {
        if (!word.isEmpty()) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).
                    toLowerCase()).append(" ");
        }
    }

    return result.toString().trim();
    
} 
    private String autoCorrectCourse(String course, String department) {
    if (course == null || course.isEmpty()) {
        return course;  // Return the course if it's null or empty
    }

    // Check if the department is Elementary or Junior High
    if ("Elementary".equalsIgnoreCase(department) || "Junior High".equalsIgnoreCase(department)) {
        // Convert the first letter to uppercase and the rest to lowercase
        return Character.toUpperCase(course.charAt(0)) + course.substring(1).toLowerCase();
    } else {
        // For College and Senior High, convert the entire course to uppercase
        return course.toUpperCase();
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

        Gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SEARCH = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Fname = new javax.swing.JTextField();
        Lname = new javax.swing.JTextField();
        department = new javax.swing.JTextField();
        YL = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Show = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Chief = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Course = new javax.swing.JTextField();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        CLEAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SCHOOL CLINIC RECORD");

        SEARCH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("First name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Last name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Department:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Year level:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Date:");

        Fname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnameActionPerformed(evt);
            }
        });

        Lname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameActionPerformed(evt);
            }
        });

        department.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        department.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });

        YL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        YL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        YL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YLActionPerformed(evt);
            }
        });

        Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(204, 255, 204));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(153, 255, 204));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 102, 102));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Last name", "First name", "Age", "Gender", "Department", "Course/Strand/Section", "Year level", "Date", "Chief Complaint"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        Show.setBackground(new java.awt.Color(255, 255, 204));
        Show.setText("SHOW");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Chief Compliant:");

        Chief.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Chief.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Age:");

        Age.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Course/Strand/Section:");

        Course.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseActionPerformed(evt);
            }
        });

        Gender.add(Male);
        Male.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Male.setText("Male");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });

        Gender.add(Female);
        Female.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Female.setText("Female");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });

        CLEAR.setText("CLEAR");
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(department, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(Chief, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(Lname)))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fname, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(Course)
                            .addComponent(YL))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Male)
                                    .addComponent(Female))
                                .addGap(180, 180, 180))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(Show)
                        .addGap(18, 18, 18)
                        .addComponent(update)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(CLEAR)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(department, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(Date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(Chief, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(YL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Male))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Female)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(Show)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(CLEAR))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FnameActionPerformed

    private void LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentActionPerformed

    private void YLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YLActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
         if (isEmptyField(Fname) || isEmptyField(Lname) || isEmptyField(Age)  ||
                isEmptyField(department) || isEmptyField(Course) ||
                isEmptyField(YL) || isEmptyField(Date) || isEmptyField(Chief)) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields before adding.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        highlightEmptyFields();
        
        
        String firstName = autoCorrect(Fname.getText());
        String lastName = autoCorrect(Lname.getText());
        String age = Age.getText();
        String dept = autoCorrect(department.getText());
        String course = autoCorrectCourse(Course.getText(), dept);
        String yearLevel = YL.getText();
        String date = Date.getText();
        String comply = autoCorrect(Chief.getText());
       
        
        
        String gender = "Gender";
        if (Male.isSelected()) {
        gender = "Male";
        } else if (Female.isSelected()) {
        gender = "Female";
        } else {
        JOptionPane.showMessageDialog(this,"Please select your gender.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
       

    // Check if the combination of department and course/strand is allowed
    if (!isCombinationAllowed(dept, course)) {
        JOptionPane.showMessageDialog(this, "Invalid combination of department and course/strand.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
       if (!isValidAge(age)) {
        handleInvalidAge();
        return;
    }
        if (!isValidYearLevel(yearLevel, dept)) {
       handleInvalidYearLevel();
        return;
    }

    if (!isValidDate(date)) {
        handleInvalidDate();
        return;
    }

    if (!isValidDepartment(dept)) {
        handleInvalidDepartment();
        return;
    }
         String formattedData = lastName + "," + firstName + "," + age + "," +gender+ "," + dept + "," +course+ ","
                 + yearLevel + "," + date + "," + comply + "\n";
        saveDataToFile(formattedData);
        

        // Add data to table
        tableModel.addRow(new Object[]{lastName, firstName, age,gender, dept, course, yearLevel, date, comply});
        
        Fname.setText("");
        Lname.setText("");
        Age.setText("");
        department.setText("");
        Course.setText("");
        YL.setText("");
        Date.setText("");  
        Chief.setText("");
        Gender.clearSelection();
    }//GEN-LAST:event_addActionPerformed

    private boolean isEmptyField(javax.swing.JTextField textField) {
    return textField.getText().trim().isEmpty();
}
    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);

    try {
        // Read data from the file
        BufferedReader reader = new BufferedReader(new FileReader("clinic_records.txt"));

        // Populate the table model with data from the file
        String line;
        while ((line = reader.readLine()) != null) {
            String[] rowData = line.split(",");
            tableModel.addRow(rowData);
        }

        reader.close();

        // Sort the table by the date column in descending order
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 7; // Assuming the date column is at index 7
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    } catch (IOException e) {
        // Handle the exception (e.g., show an error dialog)
        JOptionPane.showMessageDialog(this, "Error reading data from the file.", 
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ShowActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to update.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (isEmptyField(Fname) || isEmptyField(Lname) || isEmptyField(Age)  ||
                isEmptyField(department) || isEmptyField(Course) ||
                isEmptyField(YL) || isEmptyField(Date) || isEmptyField(Chief)) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields before adding.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    

    // Get updated data from text fields
    String updatedFirstName = autoCorrect(Fname.getText());
    String updatedLastName = autoCorrect(Lname.getText());
    String updatedAge = Age.getText(); 
    String updatedDept = autoCorrect(department.getText());
    String updatedYearLevel = YL.getText();
    String updatedDate = Date.getText();
    String updatedChief = autoCorrect(Chief.getText());
    
   String updatedgender = null;

    // Check the state of the radio buttons
    if (Male.isSelected()) {
        updatedgender = "Male";
    } else if (Female.isSelected()) {
        updatedgender = "Female";
    } else {
        JOptionPane.showMessageDialog(this, "Please select your gender.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return; // Abort the update process if gender is not selected
    }
    

    // Get updated course
   String updatedcourse = autoCorrectCourse(Course.getText(), updatedDept); 
    
    
    if (!isCombinationAllowed(updatedDept, updatedcourse)) {
        JOptionPane.showMessageDialog(this, "Invalid combination of"
                + " department and course/strand/section.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
       if (!isValidAge(updatedAge)) {
        handleInvalidAge();
        return;
    }
       if (!isValidYearLevel(updatedYearLevel, updatedDept)) {
       handleInvalidYearLevel();
        return;
    }

    // Validate the updated data (add your validation logic here)
    

    if (!isValidDate(updatedDate)) {
        handleInvalidDate();
        return;
    }
    

    

    // Update the JTable
    
    jTable1.setValueAt(updatedLastName, selectedRow, 0);
    jTable1.setValueAt(updatedFirstName, selectedRow, 1);
    jTable1.setValueAt(updatedAge, selectedRow, 2);
    jTable1.setValueAt(updatedgender,selectedRow,3);
    jTable1.setValueAt(updatedDept, selectedRow, 4);
    jTable1.setValueAt(updatedcourse, selectedRow, 5);
    jTable1.setValueAt(updatedYearLevel, selectedRow, 6);
    jTable1.setValueAt(updatedDate, selectedRow, 7);
    jTable1.setValueAt(updatedChief, selectedRow, 8);

    
    saveUpdatedDataToFile();

    // Clear the text fields after updating
    clearTextFields();
    


    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Optionally, you can ask for confirmation
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    // Remove the selected row from the table
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.removeRow(selectedRow);

    // Optionally, you can save the updated data to a file
    saveUpdatedDataToFile();

    // Clear the text fields after deleting
    clearTextFields();
    }//GEN-LAST:event_deleteActionPerformed

    private void CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        // TODO add your handling code here:
        clearTextFields();
        jTable1.clearSelection();
    }//GEN-LAST:event_CLEARActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String searchTerm = SEARCH.getText().trim();

    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Clear existing table data
    tableModel.setRowCount(0);

    try {
        // Read data from the file
        BufferedReader reader = new BufferedReader(new FileReader("clinic_records.txt"));

        // Populate the table model with rows that match the search term (Last Name)
        String line;
        while ((line = reader.readLine()) != null) {
            String[] rowData = line.split(",");
            
            // Check if the Last Name matches the search term
            if (rowData.length > 0 && rowData[0].equalsIgnoreCase(searchTerm)) {
                tableModel.addRow(rowData);
            }
        }

        reader.close();

        // If no match is found, show a message
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No matching records found in File .", 
                    "Not Found", JOptionPane.ERROR_MESSAGE);
        }

    } catch (IOException e) {
        // Handle the exception (e.g., show an error dialog)
        JOptionPane.showMessageDialog(this, "Error reading data from the file.", 
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_searchActionPerformed
    
    // Method to save updated data to a file
private void saveUpdatedDataToFile() {
    try {
        FileWriter fileWriter = new FileWriter("clinic_records.txt", false); // Set true if you want to append
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        // Iterate through the table data and save it to the file
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                printWriter.print(jTable1.getValueAt(i, j));
                if (j < jTable1.getColumnCount() - 1) {
                    printWriter.print(",");
                }
            }
            printWriter.println();
        }
        String gender;
        if (Male.isSelected()) {
        gender = "Male";
        } else if (Female.isSelected()) {
        gender = "Female";
         } else {
        // No gender selected, handle accordingly (you may want to highlight or display an error message)
        gender = "Gender"; // or any default value you prefer
        // You may want to display an error message or take appropriate action here
        return;
    }

        printWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception (show a message dialog, log the error, etc.)
    }
}

// Method to clear the text fields
private void clearTextFields() {
        Fname.setText("");
        Lname.setText("");
        Age.setText("");
        Gender.clearSelection();
        department.setText("");
        YL.setText("");
        Course.setText("");
        Date.setText("");
        Chief.setText("");
}

    private void handleTableSelection() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        // Get data from the selected row
        
        String lastName = jTable1.getValueAt(selectedRow, 0).toString();
        String firstName = jTable1.getValueAt(selectedRow, 1).toString();
        String age = jTable1.getValueAt(selectedRow, 2).toString();
        String gender = jTable1.getValueAt(selectedRow, 3).toString(); // Assuming Gender is at index 3
        String dept = jTable1.getValueAt(selectedRow, 4).toString();
        String course = jTable1.getValueAt(selectedRow, 5).toString(); // Assuming Course is at index 5
        String yearLevel = jTable1.getValueAt(selectedRow, 6).toString();
        String date = jTable1.getValueAt(selectedRow, 7).toString();
        String chief = jTable1.getValueAt(selectedRow, 8).toString();
        // Populate text fields
        Fname.setText(firstName);
        Lname.setText(lastName);
        Age.setText(age);
        setGenderRadioButton(gender); 
        department.setText(dept);
        Course.setText(course);
        YL.setText(yearLevel);
        Date.setText(date);
        Chief.setText(chief);
    }
}

private void setGenderRadioButton(String gender) {
    if (gender.equalsIgnoreCase("Male")) {
        Male.setSelected(true);
    } else if (gender.equalsIgnoreCase("Female")) {
        Female.setSelected(true);
    }
    // Add handling for other cases if needed
}
    private void handleInvalidYearLevel() {
    JOptionPane.showMessageDialog(this, "Invalid year level for the selected department.", 
            "Error", JOptionPane.ERROR_MESSAGE);
}

// New method for handling invalid date
private void handleInvalidDate() {
    JOptionPane.showMessageDialog(this, "Invalid date. Please enter a valid value.", 
            "Error", JOptionPane.ERROR_MESSAGE);
}

// New method for handling invalid department
private void handleInvalidDepartment() {
    JOptionPane.showMessageDialog(this, "Invalid department. Please enter 'Elementary',"
            + " 'High School', or 'College'.", "Error", JOptionPane.ERROR_MESSAGE);
}
    private boolean isValidYearLevel(String yearLevel, String dept) {
    if ("College".equalsIgnoreCase(dept)) {
        // If the department is College, allow year levels 1, 2, 3, 4
        return yearLevel.matches("[1-4]");
    } else if ("Elementary".equalsIgnoreCase(dept)) {
        // If the department is Elementary, allow year levels 1-6
        return yearLevel.matches("[1-6]");
    } else if ("Junior high".equalsIgnoreCase(dept)) {
        // If the department is Junior High, allow year levels 7-10
        return yearLevel.matches("[7-9]|10");
    } else if ("Senior high".equalsIgnoreCase(dept)) {
        // If the department is Senior High, allow year levels 11-12
        return yearLevel.matches("1[1-2]");
    } else {
        // For other departments, allow any year level (adjust as needed)
        return true;
    }
}

    private boolean isValidDepartment(String dept) {
    String[] validDepartments = {"Elementary", "Junior high","Senior high", "College"};
    for (String validDept : validDepartments) {
        if (dept.equalsIgnoreCase(validDept)) {
            return true;
        }
    }
    return false;
}
    private boolean isValidAge(String age) {
    try {
        int ageValue = Integer.parseInt(age);
        return true; // Accept any integer value
    } catch (NumberFormatException e) {
        return false;
    }
}
    private boolean isCombinationAllowed(String department, String course) {
    // Implement your logic for allowed combinations here

    if (department.equalsIgnoreCase("College")) {
        // Allowed courses for College
        String[] allowedCourses = {"BSBA", "BSA", "BSCS","BSOA", "BSIT", "BACOMM", "BSN", "BSCE", "BSME", "BSEE",
        "LLB", "BAP", "BSHRM", "BEEd", "BSEd", "BS Biology", "BSP", "BS Chemistry",
        "BSES", "BAPolSci", "BST", "BSCrim", "BSSW", "BSEcon", "BSA", "BFA"};

        for (String allowedCourse : allowedCourses) {
            if (course.equalsIgnoreCase(allowedCourse)) {
                return true; // Allow the combination
            }
        }
        return false; // Disallow other courses for College
    }
    if (department.equalsIgnoreCase("Junior high")) {
        // Disallow any combination that matches College or Senior High
        String[] disallowedCoursesAndStrands = {"BSBA", "BSA", "BSCS", "BSIT", "BACOMM","BSOA", "BSN", "BSCE", "BSME", "BSEE",
        "LLB", "BAP", "BSHRM", "BEEd", "BSEd", "BS Biology", "BSP", "BS Chemistry",
        "BSES", "BAPolSci", "BST", "BSCrim", "BSSW", "BSEcon", "BSA", "BFA","STEM", "ABM", "HUMSS", "TVL", "GAS"};

        for (String disallowedCourseOrStrand : disallowedCoursesAndStrands) {
            if (course.equalsIgnoreCase(disallowedCourseOrStrand)) {
                return false; // Disallow the combination
            }
        }
        return true; // Allow other combinations for Junior high
    }

    if (department.equalsIgnoreCase("Senior high")) {
        // Allowed strands for Highschool
        String[] allowedStrands = {"STEM", "ABM", "HUMSS", "GAS","TVL"};

        for (String allowedStrand : allowedStrands) {
            if (course.equalsIgnoreCase(allowedStrand)) {
                return true; // Allow the combination
            }
        }
        return false; // Disallow other strands for Senior high
    }

    if (department.equalsIgnoreCase("Elementary")) {
        // Disallow any combination that matches College or Highschool
        String[] disallowedCoursesAndStrands = {"BSBA", "BSA", "BSCS","BSOA", "BSIT", "BACOMM", "BSN", "BSCE", "BSME", "BSEE",
        "LLB", "BAP", "BSHRM", "BEEd", "BSEd", "BS Biology", "BSP", "BS Chemistry",
        "BSES", "BAPolSci", "BST", "BSCrim", "BSSW", "BSEcon", "BSA", "BFA","STEM", "ABM", "HUMSS", "TVL", "GAS"};

        for (String disallowedCourseOrStrand : disallowedCoursesAndStrands) {
            if (course.equalsIgnoreCase(disallowedCourseOrStrand)) {
                return false; // Disallow the combination
            }
        }
        return true; // Allow other combinations for Elementary
    }

    // For unknown departments, disallow the combination
    return false;
}

private void handleInvalidAge() {
    JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid integer value.", 
            "Error", JOptionPane.ERROR_MESSAGE);
}


    private boolean isValidDate(String date) {
        // Use a regular expression to match the desired date format
    String dateFormatRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$";

    try {
        // Check if the input matches the pattern
        if (date.matches(dateFormatRegex)) {
            // Try parsing the date to catch invalid day or month values
            String[] parts = date.split("/");
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Further checks on month, day, and year can be added if needed

            return true;
        } else {
            // Show an error message if the format is incorrect
            JOptionPane.showMessageDialog(null, "Incorrect date format. Please use MM/DD/YYYY.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Show an error message if parsing fails
        JOptionPane.showMessageDialog(null, "Invalid date. Please enter a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(School.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(School.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(School.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(School.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new School().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JButton CLEAR;
    private javax.swing.JTextField Chief;
    private javax.swing.JTextField Course;
    private javax.swing.JTextField Date;
    private javax.swing.JRadioButton Female;
    private javax.swing.JTextField Fname;
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JTextField Lname;
    private javax.swing.JRadioButton Male;
    private javax.swing.JTextField SEARCH;
    private javax.swing.JButton Show;
    private javax.swing.JTextField YL;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JTextField department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
