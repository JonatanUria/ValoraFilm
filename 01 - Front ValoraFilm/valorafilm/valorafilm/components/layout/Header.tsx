"use client";

import styles from "./Header.module.css";
import { useAuth } from "../context/AuthProvider";
import Link from "next/link";
import { useState } from "react";
import Cookies from "js-cookie";
import { apiFetch } from "@/lib/api";

export default function Header() {
  const { logged, loading, userId, user } = useAuth();
  const [open, setOpen] = useState(false);

  if (loading) return null; // o skeleton



  return logged ? (
    <header className={styles.header}>
      <h1>
        <Link href="/"><i>ValoraFilm</i></Link >
      </h1>
      <nav>
        <Link href="/about">¿Qué es ValoraFilm?</Link >

        <Link href="#" onClick={() => setOpen(!open)} className={styles.bottonright}>
          Hola {user?.nombreUsuario}
        </Link>

        {open && (
          <div className={styles.dropdown}>
            <Link href="/profile">Mi Perfil</Link>
            <Link href="#">Mis Películas</Link>
            <Link href="#"
              onClick={(e) => {
                e.preventDefault();


                const res = apiFetch("logout", {
                  method: "POST",
                  credentials: "include"
                })
                
                window.location.href = "/login"; // o donde quieras mandar
              }}>Cerrar sesión</Link>
          </div>
        )}


      </nav>
    </header>
  ) :
    (
      <header className={styles.header}>
        <h1>
          <Link href="/"><i>ValoraFilm</i></Link >
        </h1>
        <nav>
          <Link href="/about">¿Qué es ValoraFilm?</Link >
          <Link href="/login" className={styles.bottonright}>
            Iniciar Sesión/Registrarse
          </Link>
        </nav>
      </header>
    );
}