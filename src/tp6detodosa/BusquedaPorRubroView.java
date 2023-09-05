package tp6detodosa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaPorRubroView extends javax.swing.JInternalFrame {

    //modelo para la tabla de productos
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public BusquedaPorRubroView() {
        initComponents();
        armarCabecera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbRubro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        btVerTodos = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Listado ordenado por Rubro");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Elija Rubro :");

        cbRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Elija una opcion", "COMESTIBLE", "LIMPIEZA", "PERFUMERIA" }));
        cbRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRubroActionPerformed(evt);
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

        btVerTodos.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        btVerTodos.setForeground(new java.awt.Color(0, 0, 255));
        btVerTodos.setText("Ver Todos");
        btVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(cbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btVerTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRubroActionPerformed
        borrarFilas();
        //Parseo la categoria a String:
        String cat = (String) cbRubro.getSelectedItem();
        //si luego de buscar una vuelven al default muestra un cartel
        if (cat.equals("-Elija una opcion")) {
            JOptionPane.showMessageDialog(this, "Elija un Rubro:ALIMENTOS, LIMPIEZA O PERFUMERIA ");
        }
        for (Producto elem : Menu.listaProductos) {
            // Parseo el rubro del elemento en iteracion a String y compararlo en mayusculas
            String elemMayus = (String) elem.getRubro().toString().trim().toUpperCase();

            if (elemMayus.equals(cat)) {
                //crer fila en cada iteracion con los datos del producto actual
                modelo.addRow(new Object[]{
                    elem.getCodigo(),
                    elem.getDescripcion(),
                    elem.getPrecio(),
                    elem.getStock()
                });
            }
        }


    }//GEN-LAST:event_cbRubroActionPerformed

    private void btVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerTodosActionPerformed
        borrarFilas();
        for (Producto elem : Menu.listaProductos) {
            //crer fila en cada iteracion con los datos del producto actual
            modelo.addRow(new Object[]{
                elem.getCodigo(),
                elem.getDescripcion(),
                elem.getPrecio(),
                elem.getStock()
            });
        }
    }//GEN-LAST:event_btVerTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVerTodos;
    private javax.swing.JComboBox<String> cbRubro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtProductos.setModel(modelo);

    }
    //metodo para mostrar solo lo que se este buscando, 
    //este metodo te va ejecutar antes de imprimir la tabla ,para no mostrar datos de mas
    
    private void borrarFilas() {
        //le resto 1 para contar desde 0 la cantidad de filas en la tabla
        int f = jtProductos.getRowCount() - 1;
        //f tiene un valor por eso el atajo en el for
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

}
