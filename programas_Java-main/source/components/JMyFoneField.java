/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.components;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author mouri
 */
public class JMyFoneField extends JFormattedTextField
{

    public JMyFoneField()
    {
        try
        {
            MaskFormatter m = new javax.swing.text.MaskFormatter("(##)#####-####");
            m.setPlaceholderCharacter(' ');
            
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(m));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
