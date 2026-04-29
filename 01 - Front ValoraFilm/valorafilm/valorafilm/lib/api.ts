const API_URL = "http://localhost:8080";


// Por si queremos meter info los headers a futuro, se usará options

export async function apiFetch(endpoint: string, options: RequestInit = {}) {


  const res = await fetch(`${API_URL}/${endpoint}`, {
    headers: {
      "Content-Type": "application/json",
      ...(options.headers || {})
    },
    ...options
  });

  return res;
}