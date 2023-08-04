package com.reto.cinco.service;

import com.reto.cinco.entity.User;
import com.reto.cinco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;

    public List<User> getAll(){
        return repositorio.findAll();
    }

    public User getUser(Integer id) {
        Optional<User> optional = repositorio.findById(id);

        if (optional.isPresent()) return optional.get();
        else return new User();
    }

    public boolean existeEmail(String email){
        Optional<User> optional =  repositorio.findByEmail(email);

        if (optional.isPresent()) return true;
        else return false;
    }

    public User autenticarUsuario(String email, String password){
        Optional<User> optional =  repositorio.findByEmailAndPassword(email,password);
        if (optional.isPresent()) return optional.get();
        else return new User();
    }

    public User registrar(User user) {
        User userError;

        if (user.getId() != null) {
            Optional<User> optional = repositorio.findById(user.getId());

            if (optional.isPresent()){
                userError = new User();
                userError.setName("ID " + user.getId() + " YA EXISTE");
                return userError;
            }else {
                if (existeEmail(user.getEmail()) == false) {
                    return repositorio.save(user);
                } else {
                    userError = new User();
                    userError.setName("CORREO " + user.getEmail() + " YA EXISTE");
                    return userError;
                }
            }
        } else {
            userError = new User();
            userError.setName("FALTA EL ID");
            return userError;
        }
    }

    public User actualizar(User user){
        User userError;
        User userDb;

        if (user.getId()!=null){
            Optional<User> optional =  repositorio.findById(user.getId());

            if (optional.isPresent()){
                userDb = optional.get();
                if ((user.getIdentification() != null) && (!user.getIdentification().equals(""))) {
                    if (!userDb.getIdentification().equals(user.getIdentification()))  userDb.setIdentification(user.getIdentification());
                }
                if ((user.getName() != null) && (!user.getName().equals(""))) {
                    if (!userDb.getName().equals(user.getName()))  userDb.setName(user.getName());
                }
                if ((user.getBirthtDay() != null) && (!user.getBirthtDay().equals(""))) {
                    if (!userDb.getBirthtDay().equals(user.getBirthtDay()))  userDb.setBirthtDay(user.getBirthtDay());
                }
                if ((user.getMonthBirthtDay() != null) && (!user.getMonthBirthtDay().equals(""))) {
                    if (!userDb.getMonthBirthtDay().equals(user.getMonthBirthtDay()))  userDb.setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if ((user.getAddress() != null) && (!user.getAddress().equals(""))) {
                    if (!userDb.getAddress().equals(user.getAddress())) userDb.setAddress(user.getAddress());
                }
                if ((user.getCellPhone() != null) && (!user.getCellPhone().equals(""))) {
                    if (!userDb.getCellPhone().equals(user.getCellPhone()))userDb.setCellPhone(user.getCellPhone());
                }
                if ((user.getEmail() != null) && (!user.getEmail().equals(""))) {
                    if (!userDb.getEmail().equals(user.getEmail())) userDb.setEmail(user.getEmail());
                }
                if ((user.getPassword() != null) && (!user.getPassword().equals(""))) {
                    if (!userDb.getPassword().equals(user.getPassword())) userDb.setPassword(user.getPassword());
                }
                if ((user.getZone() != null) && (!user.getZone().equals(""))) {
                    if (!userDb.getZone().equals(user.getZone())) userDb.setZone(user.getZone());
                }

                if ((user.getType() != null) && (!user.getType().equals(""))) {
                    if (!userDb.getType().equals(user.getType())) userDb.setType(user.getType());
                }

                return repositorio.save(userDb);
            }else{
                userError = new User();
                userError.setName("No existe un usuario con el ID " + user.getId());
                return userError;
            }
        }else{
            userError = new User();
            userError.setName("No se envio un valor para el ID");
            return userError;
        }
    }

    public boolean delete(int id) {
        User userDelete;
        Optional<User> optional = repositorio.findById(id);

        if (optional.isPresent()){
            userDelete = optional.get();
            repositorio.delete(userDelete);
            return true;
        }else{
            return false;
        }
    }

    public List<User> findByMonthBirthtDay(String monthBirthtDay){
        return repositorio.findByMonthBirthtDay(monthBirthtDay);
    }

    public List <User> usuariosCumpleMes(String monthBirthtDay){
        return repositorio.usuariosCumpleMes(monthBirthtDay);
    }
}