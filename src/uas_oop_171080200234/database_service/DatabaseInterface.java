/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service;

import java.util.List;

/**
 *
 * @author naufalnibros
 */
public interface DatabaseInterface<T> {
    void onResult(List<T> list);
    void onSuccess();
    void onError(String message);
    void onProcess();
}
