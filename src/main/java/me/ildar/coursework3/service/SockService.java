package me.ildar.coursework3.service;

import me.ildar.coursework3.model.Sock;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class SockService {
    private static Map<Integer, Sock> socks = new LinkedHashMap<>();
    private static int id = 0;

    public String add(Sock sock) {
        socks.put(++id, sock);
        return "Добавлены носки: цвет " + sock.getColor();
    }

    public Optional<Sock> get(int id) {
        return Optional.ofNullable(socks.get(id));

    }




}
