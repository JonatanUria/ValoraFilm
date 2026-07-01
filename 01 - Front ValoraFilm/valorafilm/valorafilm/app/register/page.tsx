"use client";

import styles from './Register.module.css';
import { useState } from "react";
import { apiFetch } from "@/lib/api";
import { FaEye, FaEyeSlash } from 'react-icons/fa';
import { FaUser, FaEnvelope, FaLock } from "react-icons/fa";

export default function Register() {
  // Declaración de variables
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [birthdate, setbirthdate] = useState("");
  const [showPassword, setShowPassword] = useState(false);

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
        <div className={styles.formgroup}>
          <label htmlFor='userusername'>Nombre de Usuario:</label>
          <div className={styles.inputwrapper}>
            <FaUser className={styles.inputicon} />
            <input
              type="text"
              id='userusername'
              placeholder='Nombre'
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
        </div>

        <div className={styles.formgroup}>
          <label htmlFor="email">Email:</label>
          <div className={styles.inputwrapper}>
            <FaEnvelope className={styles.inputicon} />
            <input
              type="email"
              id="email"
              placeholder='email@ejemplo.com'
              required
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
        </div>

        <div className={styles.formgroup}>
          <div className={styles.passwordcontainer}>
            <label htmlFor="password">Contraseña:</label>
            <div className={styles.inputwrapper}>
              <FaLock className={styles.inputicon} />
              <input
                type={showPassword ? "text" : "password"}
                id="password"
                placeholder='Contraseña'
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
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
        </div>

        <div className={styles.formgroup}>
          <label htmlFor="birthdate">Fecha de Nacimiento (Opcional):</label>
          <input
            type="date"
            id='birthdate'
            max="2015-05-29"
            value={birthdate}
            onChange={(e) => setbirthdate(e.target.value)}
          />
        </div>

        <button type="submit" className={styles.button}>Registrate</button>
        <p className={styles.logintext}>¿Ya tienes cuenta? <a href="\login">Inicia sesión</a>
        </p>
      </form>
    </div>
  );
}