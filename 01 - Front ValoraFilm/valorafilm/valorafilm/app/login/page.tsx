"use client";

import { useState } from "react";
import styles from './Login.module.css'
import { apiFetch } from "@/lib/api";
import Link from "next/link";
import { FaEye, FaEyeSlash } from "react-icons/fa";
import { FaUser, FaLock } from "react-icons/fa";

export const delay = (ms: number) =>
  new Promise<void>(resolve => setTimeout(resolve, ms));

export default function Login() {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);
  const [showPassword, setShowPassword] = useState(false);


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
        <div className={styles.logo}>🎬</div>
        <h2 className={styles.title}> Inicio de Sesión </h2>
        <div className={styles.inputwrapper}>
          <FaUser className={styles.inputicon} />
          <input type="text" id="username" name="username" placeholder='Nombre de Usuario'
            onChange={(event) => setUsername(event.target.value)}
          />
        </div>
        <div className={styles.passwordcontainer}>
          <div className={styles.inputwrapper}>
            <FaLock className={styles.inputicon} />
            <input type={showPassword ? "text" : "password"} id="pwd" name="pwd" placeholder='Contraseña'
              onChange={(event) => setPassword(event.target.value)}
            />
            <button
              type="button"
              className={styles.eyebutton}
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? <FaEyeSlash /> : <FaEye />}
            </button>
          </div>
        </div>

        <button type="submit" className={styles.button}>Inicia Sesión</button>
        <Link href="/register" className={styles.button}>Regístrate </Link >
        {error && (
          <p className={styles.error}>
            Credenciales incorrectas
          </p>
        )}
      </form>
    </div>

  );
}
