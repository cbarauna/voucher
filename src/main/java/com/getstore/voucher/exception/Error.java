package com.getstore.voucher.exception;

import java.time.LocalDateTime;

public class Error {
    private LocalDateTime data;
    private Integer estatus;
    private String erro;
    private String messagem;

    public LocalDateTime getData() {
        return LocalDateTime.now();
    }

    public void setData() {
        this.data = LocalDateTime.now();
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
