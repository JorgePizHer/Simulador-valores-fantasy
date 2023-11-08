package simuladorvaloresfantasy;

import javax.swing.GroupLayout;

public class SimuladorValoresFantasy extends javax.swing.JFrame {

    public SimuladorValoresFantasy() {
    
        initComponents();
    }

    private void initComponents() {
        //Inicializo componentes
        jPanel1 = new javax.swing.JPanel();      
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        
        //Comportamiento de cerrar ventana
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //Textos por defecto en los componentes
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20));
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1. setText("Simulador valores fantasy");
        jLabel2. setText("Introduce el valor del jugador");
        jLabel3. setText("Indica los días restantes para que comience la jornada");
        jLabel4. setText("Indica la última fluctuación de valor del jugador");
        jButton1. setText("Calcula su posible valor al comienzo de la jornada");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Equipos:", "Real Madrid", "Barcelona", "Getafe"}));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Jugadores:", "Vinicus", "Bellingham", "Camavinga"}));
        
        //Añado escuchadores
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
       
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        
        //Maquetación gráfica
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(58, 100, 100)
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                
                .addComponent(jLabel1)        
                .addComponent(jComboBox1)
                .addComponent(jComboBox2)
                .addComponent(jLabel2)
                .addComponent(jTextField1)
                .addComponent(jLabel3)
                .addComponent(jSpinner1,60,60,60)
                .addComponent(jLabel4)        
                .addComponent(jTextField2)
                .addComponent(jButton1)
                .addComponent(jLabel5))
                .addContainerGap(100, Short.MAX_VALUE)
                )
        );
        
        
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jComboBox1)
                .addGap(10, 10, 10)
                .addComponent(jComboBox2)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addComponent(jTextField1)
                .addGap(10, 10, 10)        
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jSpinner1)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addComponent(jTextField2)
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addContainerGap(100, Short.MAX_VALUE))
        );  
        
        pack();
    }

    //Métodos de los escuchadores
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    
        //Capturo los datos
        System.out.println("Has pulsado el botón");
        String valorJugador = jTextField1.getText();
        int diasRestantes = (int) jSpinner1.getValue();
        String variacionValor = jTextField2.getText();
        
        //Conversiones de tipo y operaciones
       try {
            int valorJugadorNumero = Integer.parseInt(valorJugador);
            int variacionValorNumero = Integer.parseInt(variacionValor);
            int valorJornada = valorJugadorNumero + (variacionValorNumero * diasRestantes);

            String valorJornadaString = String.valueOf(valorJornada);
            
            jLabel5.setText("El valor de " + jComboBox2ActionPerformed(evt) + " sería de: " + valorJornadaString);
            
            if (valorJornada > valorJugadorNumero) {
            jLabel5.setForeground(new java.awt.Color(0, 204, 102));
            }else {
            jLabel5.setForeground(new java.awt.Color(255, 102, 102));
            }
            
            jTextField1.setText("");
            jTextField2.setText("");
       }catch(Exception e) {
       
           System.out.println(e.getMessage());
       }
    
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.out.println("Has seleccionado algo");
        String seleccion = (String) jComboBox1.getSelectedItem();
        System.out.println("El equipo que has seleccionado es: " + seleccion);
        
        switch (seleccion) {
        
            case "Real Madrid": 
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Jugadores:", "Vinicus", "Bellingham", "Camavinga"}));
                break;
            case "Barcelona":
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Jugadores:", "Lewandowski", "Fermín", "Araujo"}));
                break;
            case "Getafe":
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Jugadores:", "Damián", "Djene", "Greenwood"}));
                break;
        }
        
    }
   
    private String jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.out.println("Has seleccionado un jugador");
        String nombreJugador = (String) jComboBox2.getSelectedItem();
        System.out.println("Has seleccionado a " + nombreJugador);
        
        return nombreJugador;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimuladorValoresFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorValoresFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorValoresFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorValoresFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorValoresFantasy().setVisible(true);
            }
        });
        
    }
    
    //Declaración de variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JSpinner jSpinner1;
}
    
    
    
    
    

