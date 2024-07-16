/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author HP
 */
public class TokenForgetPassword {
    private int id, accId;
    private boolean isUsed;
    private String token;
    private LocalDateTime expiryTime;

    public TokenForgetPassword() {
    }

    public TokenForgetPassword(int id, int accId, boolean isUsed, String token, LocalDateTime expiryTime) {
        this.id = id;
        this.accId = accId;
        this.isUsed = isUsed;
        this.token = token;
        this.expiryTime = expiryTime;
    }

    public TokenForgetPassword(int userId, boolean isUsed, String token, LocalDateTime expiryTime) {
        this.accId = userId;
        this.isUsed = isUsed;
        this.token = token;
        this.expiryTime = expiryTime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int userId) {
        this.accId = userId;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public String toString() {
        return "TokenForgetPassword{" + "id=" + id + ", userId=" + accId + ", isUsed=" + isUsed + ", token=" + token + ", expiryTime=" + expiryTime + '}';
    }
}
