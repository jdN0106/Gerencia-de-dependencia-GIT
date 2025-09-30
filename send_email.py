import os
import smtplib
from email.message import EmailMessage

SENDER_EMAIL = os.environ.get("MAIL_USERNAME")
SENDER_PASSWORD = os.environ.get("MAIL_PASSWORD")
RECIPIENT_EMAIL = os.environ.get("MAIL_RECIPIENT")

msg = EmailMessage()
msg["Subject"] = "Execução do Pipeline do GitHub Actions"
msg["From"] = SENDER_EMAIL
msg["To"] = RECIPIENT_EMAIL
msg.set_content("O pipeline de CI/CD foi executado com sucesso!")

try:
    with smtplib.SMTP_SSL("smtp.gmail.com", 465) as smtp:
        print("A iniciar sessão no servidor de e-mail...")
        smtp.login(SENDER_EMAIL, SENDER_PASSWORD)

        print("A enviar o e-mail...")
        smtp.send_message(msg)

        print(f"E-mail de notificação enviado com sucesso para {RECIPIENT_EMAIL}!")

except Exception as e:
    print(f"Ocorreu um erro ao enviar o e-mail: {e}")