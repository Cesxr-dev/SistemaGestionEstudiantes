/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import implementacion.BinarySearchTree;
import model.Estudiante;

/**
 *
 * @author demib
 */
public class GestionSistemaService {
    private final BinarySearchTree<Estudiante> arbolEstudiantes = new BinarySearchTree<>();
    
    public void agregarEstudiante(Estudiante est){
        arbolEstudiantes.insertar(est);
        
        arbolEstudiantes.inOrder();
    }
}
