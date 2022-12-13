/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Forma_pagamento;
import br.univates.persistencia.DaoFactory;
import br.univates.source.persistence.IDao;
import br.univates.source.persistence.InvalidKeyException;
import br.univates.source.persistence.KeyViolationException;
import br.univates.source.persistence.NotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Tela_cad_pagamento extends javax.swing.JFrame {

    /**
     * Creates new form Tela_cad_pagamento
     */
    
    private Forma_pagamento forma;
    ArrayList<Forma_pagamento> lista;
    
    public Tela_cad_pagamento(ArrayList<Forma_pagamento> lista) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        forma=new Forma_pagamento();
        this.lista=lista;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancelar = new javax.swing.JButton();
        btCriar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        BtAtualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        TextoNumero = new javax.swing.JTextField();
        lbEn = new javax.swing.JLabel();
        textoTipo = new javax.swing.JTextField();
        lbRua = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btCriar.setText("Cadastrar");
        btCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarActionPerformed(evt);
            }
        });

        btDeletar.setText("Deletar");
        btDeletar.setToolTipText("Só é necessário o ID para essa ação.");
        btDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeletarMouseEntered(evt);
            }
        });
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        BtAtualizar.setText("Atualizar");
        BtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAtualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Cartão");

        textoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoIDActionPerformed(evt);
            }
        });
        textoID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoIDKeyTyped(evt);
            }
        });

        lbEn.setText("ID do pagamento");

        textoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTipoActionPerformed(evt);
            }
        });

        lbRua.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(BtAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btCriar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRua)
                            .addComponent(lbEn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(textoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btCriar)
                    .addComponent(btDeletar)
                    .addComponent(BtAtualizar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarActionPerformed

        Integer id = Integer.parseInt(this.textoID.getText());
        String tipo = this.textoTipo.getText();
        String num = this.TextoNumero.getText();

        boolean create = (this.forma.getPk() == null);

        this.forma.setPk(id);
        this.forma.setTipo(tipo);
        this.forma.setNum_cartao(num);

        IDao<Forma_pagamento, Integer> dao = DaoFactory.createForma_pagamentoDao();

        try {
            if (create) {
                dao.create(forma);
            }
        } catch (KeyViolationException | InvalidKeyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        dispose();
    }//GEN-LAST:event_btCriarActionPerformed

    private void btDeletarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletarMouseEntered

    }//GEN-LAST:event_btDeletarMouseEntered

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        IDao<Forma_pagamento, Integer> dao = DaoFactory.createForma_pagamentoDao();

        try {
            dao.delete(Integer.parseInt(this.textoID.getText()));
            JOptionPane.showMessageDialog(null, "Deletado.", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar.", "Problema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    private void BtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAtualizarActionPerformed
        IDao<Forma_pagamento, Integer> dao = DaoFactory.createForma_pagamentoDao();

        Integer id = Integer.parseInt(this.textoID.getText());
        String tipo = this.textoTipo.getText();
        String num = this.TextoNumero.getText();

        boolean create = (this.forma.getPk() == null);

        this.forma.setPk(id);
        this.forma.setTipo(tipo);
        this.forma.setNum_cartao(num);

        try {
            if (create) {
                dao.update(forma);
            }else{
                System.out.println("Erro com o ID.");
            }
        } catch (NotFoundException ex) {
            Logger.getLogger(Tela_cad_endereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_BtAtualizarActionPerformed

    private void textoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoIDActionPerformed

    }//GEN-LAST:event_textoIDActionPerformed

    private void textoIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIDKeyPressed

    }//GEN-LAST:event_textoIDKeyPressed

    private void textoIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoIDKeyTyped
        if (this.textoID.getText().length() != 0) {
            try {
                Integer.parseInt(this.textoID.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Esse campo só aceita números inteiros.", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                this.textoID.grabFocus();
            }
        }
    }//GEN-LAST:event_textoIDKeyTyped

    private void textoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAtualizar;
    private javax.swing.JTextField TextoNumero;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCriar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbEn;
    private javax.swing.JLabel lbRua;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoTipo;
    // End of variables declaration//GEN-END:variables
}