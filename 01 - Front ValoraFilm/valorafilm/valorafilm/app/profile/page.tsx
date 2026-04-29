"use client";
import { useAuth } from "@/components/context/AuthProvider";
import styles from './Profile.module.css';

export default function Perfil() {
    const { user } = useAuth();

    if (!user) return <p>Cargando...</p>;

    return (
        <div className={styles.profileContainer}>
            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Perfil"></img>
            <p><b>Nombre de Usuario:</b> {user.nombreUsuario}</p>
            <p><b>Email:</b> {user.email}</p>
            <p><b>País:</b> {user.paisOrigen}</p>
            <p><b>Género:</b> {user.genero}</p>
            <p><b>Fecha de Nacimiento:</b> {user.fechaNacimiento}</p>
            <p><b>Fecha de Alta en la web:</b> {user.fechaRegistro}</p>
        </div>
    );
}
