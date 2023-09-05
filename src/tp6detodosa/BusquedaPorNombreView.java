package tp6detodosa;

import javax.swing.table.DefaultTableModel;

public class BusquedaPorNombreView extends javax.swing.JInternalFrame {

    //modelo para la tabla de productos
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public BusquedaPorNombreView() {
        initComponents();
        armarCabecera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtBusquedaNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        btnVerTodos = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Listado ordenado por Nombre");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Escriba las primeras Letras :");

        jtBusquedaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaNombreKeyReleased(evt);
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
        btnVerTodos.setBorder(null);
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
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtBusquedaNombre))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBusquedaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaNombreKeyReleased
        //Borro filas para mostrar solo lo que se este buscando , 
        //en caso de borrar el campo de busqueda deja la tabla en blanco
        borrarFilas();

        //Buscar por letras
        for (Producto prod : Menu.listaProductos) {
            //si el prod actual comienza con las letras ingresadas en el campo de texto 
            if (prod.getDescripcion().toUpperCase().startsWith(jtBusquedaNombre.getText().toUpperCase())) {
                //lo agrego en una fila nueva de la tabla
                modelo.addRow(new Object[]{
                    prod.getCodigo(),
                    prod.getDescripcion(),
                    prod.getPrecio(),
                    prod.getStock()
                });
            }

        }   if(jtBusquedaNombre.getText().equals("")){
            borrarFilas();
        }
    }//GEN-LAST:event_jtBusquedaNombreKeyReleased

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
           for (Producto prod : Menu.listaProductos) {
                //crer fila en cada iteracion con los datos del producto actual
                modelo.addRow(new Object[]{
                    prod.getCodigo(),
                    prod.getDescripcion(),
                    prod.getPrecio(),
                    prod.getStock()
                });
           }
    }//GEN-LAST:event_btnVerTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtBusquedaNombre;
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
