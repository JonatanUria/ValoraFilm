"use client";

import styles from './Register.module.css';
import { useState } from "react";
import { apiFetch } from "@/lib/api";

export default function Register() {
  // Declaración de variables
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [birthdate, setbirthdate] = useState("");

  // Administrar el botón de registrarse
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    try {
      const body: any = {
        username,
        email,
        password
      };

      if (birthdate) body.birthdate = birthdate;


      await apiFetch("newuser", {
        method: "POST",
        body: JSON.stringify(body)
      });


      // limpiar formulario
      setUsername("");
      setEmail("");
      setPassword("");
      setbirthdate("");

    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className={styles.container}>
      <form className={styles.form} onSubmit={handleSubmit}>

        <h2 className={styles.title}>Registrarse</h2>

        <label htmlFor='userusername'>Nombre de Usuario:</label>
        <input
          type="text"
          id='userusername'
          placeholder='Nombre'
          required
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />

        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          placeholder='email@ejemplo.com'
          required
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <label htmlFor="password">Contraseña:</label>
        <input
          type="password"
          id="password"
          placeholder='Contraseña'
          required
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <label htmlFor="birthdate">Fecha de Nacimiento (Opcional):</label>
        <input
          type="date"
          id='birthdate'
          max="2015-05-29"
          value={birthdate}
          onChange={(e) => setbirthdate(e.target.value)}
        />

        <input
          type="submit"
          value="Regístrate"
          className={styles.button}
        />
      </form>
    </div>
  );
}