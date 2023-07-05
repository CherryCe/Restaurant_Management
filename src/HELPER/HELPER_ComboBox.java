/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

/**
 *
 * @author CherryCe
 */
public class HELPER_ComboBox {

    Object value;
    Object text;

    public HELPER_ComboBox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString();
    }

    public int layMaInt() {
        return Integer.parseInt(value.toString());
    }

    public String layMaString() {
        return value.toString();
    }
}
