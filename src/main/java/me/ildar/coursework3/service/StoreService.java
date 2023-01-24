package me.ildar.coursework3.service;

import me.ildar.coursework3.model.Sock;
import me.ildar.coursework3.model.SockProduct;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StoreService {

    private final Map<Sock, Integer> socks = new LinkedHashMap<>();
    public void income(SockProduct sockProduct) {
        if (isNotValid(sockProduct)) {
            throw new IllegalArgumentException();
        }
        Sock sock = sockProduct.getSock();
        if (socks.containsKey(sockProduct.getSock())) {
            socks.replace(sockProduct.getSock(), socks.get(sock) + sockProduct.getQuantity());
        } else {
            socks.put(sockProduct.getSock(), sockProduct.getQuantity());
        }
    }
    public void release(SockProduct sockProduct) {
        Sock sock = sockProduct.getSock();
        int difference = socks.get(sock) - sockProduct.getQuantity();
        if (!socks.containsKey(sock) || isNotValid(sockProduct)) {
            throw new IllegalArgumentException();
        }
        if (difference<0) {
            throw new RuntimeException("Количество списываемого товара не может превышать количество товара на складе");
        }
        socks.replace(sock, difference);
    }
    private boolean isNotValid(SockProduct sockProduct) {
        Sock sock = sockProduct.getSock();
        return sock.getCottonPart() < 0 || sock.getCottonPart() > 100 || sockProduct.getQuantity() <= 0;
    }


}
