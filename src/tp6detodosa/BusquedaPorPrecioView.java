package tp6detodosa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaPorPrecioView extends javax.swing.JInternalFrame {

    //Modelo para la tabla de productos
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public BusquedaPorPrecioView() {
        initComponents();
        armarCabecera();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtPrecioMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtPrecioMax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        btnVerTodos = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Listado por Precio");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Entre $:");

        jtPrecioMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecioMinKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Y");

        jtPrecioMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecioMaxKeyReleased(evt);
            }
        });

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtProductos);

        btnVerTodos.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        btnVerTodos.setForeground(new java.awt.Color(0, 0, 255));
        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //evento cuando suelten una tecla en el precio max e ingrese un numero
    private void jtPrecioMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioMaxKeyReleased
        //si modifican los numeros buscados se borra todo para filtrar nuevamente
        borrarFilas();
        try {
            double pMin, pMax;
            //precios ingresados :si vienen vacios le asigno 0 para evitar exception. 
            //Si no el cartel por esa excepcion se volvia muy repetitivo 
            if (jtPrecioMin.getText().trim().equals("") || jtPrecioMax.getText().trim().equals("")) {
                pMin = 0;
                pMax = 0;
                // Si no vienen vacios, le asigno el valor que traiga,si trae caracteres entonces esa excepcion muestra su msj
            } else {
                pMin = Double.parseDouble(jtPrecioMin.getText().trim());
                pMax = Double.parseDouble(jtPrecioMax.getText().trim());
            }

            for (Producto elem : Menu.listaProductos) {
                if (elem.getPrecio() >= pMin && elem.getPrecio() <= pMax) {
                    //lo agrego en una fila nueva de la tabla
                    modelo.addRow(new Object[]{
                        elem.getCodigo(),
                        elem.getDescripcion(),
                        elem.getPrecio(),
                        elem.getStock()
                    });
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Datos incorrectos: deben ser numeros");
            borrarFilas();
            jtPrecioMin.setText("");
            jtPrecioMax.setText("");
        }
    }//GEN-LAST:event_jtPrecioMaxKeyReleased

    private void jtPrecioMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioMinKeyReleased
        //Repito lo del precioMax en el precioMin , asi filtra la lista al modificar cualquiera de los  dos precios
        //si modifican los numeros buscados se borra todo para filtrar nuevamente
        borrarFilas();
        try {
            double pMin, pMax;
            //precios ingresados :si vienen vacios le asigno 0 para evitar exception. 
            //Si no el cartel por esa excepcion se volvia muy repetitivo 
            if (jtPrecioMin.getText().trim().equals("") || jtPrecioMax.getText().trim().equals("")) {
                pMin = 0;
                pMax = 0;
                // Si no vienen vacios, le asigno el valor que traiga,si trae caracteres entonces esa excepcion muestra su msj
            } else {
                pMin = Double.parseDouble(jtPrecioMin.getText().trim());
                pMax = Double.parseDouble(jtPrecioMax.getText().trim());
            }

            for (Producto elem : Menu.listaProductos) {
                if (elem.getPrecio() >= pMin && elem.getPrecio() <= pMax) {
                    //lo agrego en una fila nueva de la tabla
                    modelo.addRow(new Object[]{
                        elem.getCodigo(),
                        elem.getDescripcion(),
                        elem.getPrecio(),
                        elem.getStock()
                    });
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Datos incorrectos: deben ingresar numeros");
            borrarFilas();
            jtPrecioMin.setText("");
            jtPrecioMax.setText("");
        }
    }//GEN-LAST:event_jtPrecioMinKeyReleased

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        borrarFilas();
        for (Producto elem : Menu.listaProductos) {
            //lo agrego en una fila nueva de la tabla
            modelo.addRow(new Object[]{
                elem.getCodigo(),
                elem.getDescripcion(),
                elem.getPrecio(),
                elem.getStock()
            });

        }
    }//GEN-LAST:event_btnVerTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtPrecioMax;
    private javax.swing.JTextField jtPrecioMin;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtProductos.setModel(modelo);

    }

    //metodo para mostrar solo lo que se este buscando, este metodo te va ejecutar antes de imprimir la tabla ,para no mostrar datos de mas
    private void borrarFilas() {
        //le resto 1 para contar desde 0 la cantidad de filas en la tabla
        int f = jtProductos.getRowCount() - 1;
        //f tiene un valor por eso el atajo en el for
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }

}
