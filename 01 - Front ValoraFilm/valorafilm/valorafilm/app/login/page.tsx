"use client";

import { useState } from "react";
import styles from './Login.module.css'
import { apiFetch } from "@/lib/api";
import Link from "next/link";

export const delay = (ms: number) =>
  new Promise<void>(resolve => setTimeout(resolve, ms));

export default function Login() {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);


  const body: any = {
    username,
    password,
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); // Evita que el formulario se envíe de forma tradicional


    const res = await apiFetch("login", {
      method: "POST",
      credentials: "include",
      body: JSON.stringify(body)
    })

    if (res.ok) {
      // ✅ Login correcto
      await delay(1000); // 500 ms = medio segundo
      console.log("Login OK");
      window.location.href = "/";
    } else {
      setError(true);
    }



    // Inicializar las variables después de haberlas utilizado.
    setUsername("");
    setPassword("");

  }

  return (
    <div className={styles.container}>
      <form className={styles.form} onSubmit={handleSubmit}>
        <h2 className={styles.title}> Inicio de Sesión </h2>

        <input type="text" id="username" name="username" placeholder='Nombre de Usuario'
          onChange={(event) => setUsername(event.target.value)}
        />

        <input type="password" id="pwd" name="pwd" placeholder='Contraseña'
          onChange={(event) => setPassword(event.target.value)}
        />

        <input type="submit" value="Inicia Sesión" className={styles.button} />
        <Link href='/register' className={styles.button}>Regístrate </Link >
        {error && (
          <p className={styles.error}>
            Credenciales incorrectas
          </p>
        )}
      </form>
    </div>

  );
}
